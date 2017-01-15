/**
 * @(#)DataBase.java, 2016年11月30日. 
 * 
 * Copyright 2016 zhoukang, Inc. All rights reserved.
 * Use of this source code is governed by the BSD 3-Clause License,
 * that can be found in the LICENSE file.
 */
package cane.kv.interfaces;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cane.kv.options.DataBaseOptions;
import cane.kv.options.DataBaseOptionsCoder;
import cane.kv.util.CaneKVFileUtils;

/**
 * 表示一个数据库
 * @author cane
 *
 */
public class DataBase extends CaneKVDB{
    private static final Logger LOG = LoggerFactory.getLogger(DataBase.class);
    
    /**
     * 数据库的名称
     */
    private String dbName;
    
    /**
     * 数据库可配置的参数
     */
    private DataBaseOptions dataBaseOptions;
    
    /**
     * 数据库状态，是否关闭
     */
    private boolean isClosed;
    
    /**
     * 文件锁，用于控制单个program访问单个配置文件
     */
    private FileLock optionsFileLock;

    /**
     * @return the dbName
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * @param dbName the dbName to set
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
        fixDataBaseName();
    }

    /**
     * @return the dataBaseOptions
     */
    public DataBaseOptions getDataBaseOptions() {
        return dataBaseOptions;
    }

    /**
     * @param dataBaseOptions the dataBaseOptions to set
     */
    public void setDataBaseOptions(DataBaseOptions dataBaseOptions) {
        this.dataBaseOptions = dataBaseOptions;
    }

    /**
     * @return the isClosed
     */
    public boolean isClosed() {
        return isClosed;
    }

    /**
     * @param isClosed the isClosed to set
     */
    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }
    
    private void fixDataBaseName() {
        if (dbName.length() >= 1 && dbName.charAt(0) == '/') {
            return; 
          } else if (dbName.length() >= 2 && dbName.charAt(0) == '.' && dbName.charAt(1) == '/') {
            this.dbName = CaneKVFileUtils.getCwd() + "/" + dbName.substring(2);
          } else {
            this.dbName = CaneKVFileUtils.getCwd() + "/" + dbName;
          }
    }
    
    /**
     * 打开或者创建一个数据库
     * 1、crete
     * 2、open
     */
    @Override
    public void open() throws KVException, IOException {
        File file = new File(dbName);
        boolean dbFileExist = file.exists();
        
        if(dbFileExist && file.isDirectory()) {
            throw new KVException.IOErrorException("A file with same name as the database already exists"
                    + " and is not a directory. Delete or rename this file to continue.@DbName" + dbName);
        }
        
        if(dbFileExist && dataBaseOptions.isErrorIfExists()) {
            throw new KVException.IOErrorException("Could not create database directory.@DbName" + dbName
                        + ",file already exist.");
        }
        
        if(!dbFileExist && dataBaseOptions.isCreateIfMissing()) {
            try {
                if(!file.createNewFile()) {
                    throw new KVException.IOErrorException("Could not create database directory.@DbName" + dbName
                        + ",create file failed.May be you can check permssion.");
                }
            } catch (IOException e) {
                throw new KVException.IOErrorException("Could not create database directory.@DbName"
                        + dbName + ",@Caused by:" + e.getMessage());
            }
        }
        
        String optionsFilePath = DataBaseOptions.getPath(dbName);
        File optionsFile = new File(optionsFilePath);
        boolean dbOptionsFileExists = optionsFile.exists();
        optionsFileLock = null;
        FileChannel fileChannel = null;
        DataBaseOptions dataBaseOptionsCandidate = null;        
        if(dbOptionsFileExists) {
            //从数据库目录读取加载配置文件
            LOG.trace("Open DataBase,loading db_options file!");
            try {
                try {
                    fileChannel = new RandomAccessFile(optionsFile, "r").getChannel();
                } catch (Exception e) {
                    LOG.error("Cloud not open options file {} with error {}", optionsFilePath, e.getMessage());
                }
                
                if(fileChannel != null) {
                    optionsFileLock = fileChannel.lock();
                }
            } catch(Exception e) {
                LOG.error("Cloud get file lock {}", e.getMessage());
            }
            if(optionsFileLock == null || !optionsFileLock.isValid()) {
                throw new KVException.IOErrorException("Could not acquire the global database lock:"
                        + " the database was already opened by another process");
            }
            
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            try {
                DataBaseOptionsCoder.decodeFrom(buffer, fileChannel.size(), dataBaseOptionsCandidate);
                dataBaseOptions = dataBaseOptionsCandidate;
            } catch (KVException e) {
                dataBaseOptionsCandidate = null;
                LOG.warn("Cloud not open database options file {} !", e.getMessage());
            }
        }
        
        if(dbFileExist && (!dbOptionsFileExists || dataBaseOptionsCandidate == null)) {
            //数据库文件夹已经创建了，但是不存在配置文件，从持久化的哈希表恢复
        }
        
        if(!dbFileExist || !dbOptionsFileExists || dataBaseOptionsCandidate == null) {
            //如果：1、没有创建过同名数据库目录；2、数据库配置文件不存在；3、数据库配置存在，但是数据不正确
            //那么就创建或者重写一下
        }
        
    }

}
