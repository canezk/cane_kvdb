/**
 * @(#)DataBaseOptions.java, 2016年11月30日. 
 * 
 * Copyright 2016 zhoukang, Inc. All rights reserved.
 * Use of this source code is governed by the BSD 3-Clause License,
 * that can be found in the LICENSE file.
 */
package cane.kv.options;

/**
 * 数据库的参数java bean
 * 1、数据库具有create，open操作，这些时候参数要做区分
 * 2、有些对每个db共享的参数
 * @author cane
 *
 */
public class DataBaseOptions {
    
    private static final String DB_OPTIONS = "/db_options";
    
    public static String getPath(String dbName) {
        return dbName + DB_OPTIONS;
    }
    
    //*************** 以下是数据库启动之后的参数 *************//
    //********** 创建create之后就不能再改变 ***********************//
    
    /**
     * 哈希算法类型
     */
    private HashType hashType;
    
    /**
     * 数据压缩算法的参数
     */
    private CompressionOptions compressionOptions;
    
    /**
     * 校验和算法类型
     */
    private CheckSumType checkSumType;
    
    /**
     * 一个存储文件最大值
     * notice:对于单个的大于这个值的entry，不算在里面
     */
    private long storageHstableSize;
    
    /**
     * 数据库采用的压缩算法
     */
    private String storageCompressionAlgorithm;
    
    /**
     * key/value 采用的哈希算法
     */
    private String storageHashingAlgorithm;
    
    //******************** 实例参数，open的时候可以设置**************//
    /**
     * db不存在就创建，默认true
     */
    private boolean createIfMissing;
    
    /**
     * 如果db存在，就退出，默认false
     */
    private boolean errorIfExists;
    
    /**
     * WriteBuffer size
     */
    private long writeBufferSize;
    
    /**
     * 数据从cache持久化到filesystem的间隔时间
     */
    private long writeBufferFlushTimeout;

    /**
     * @see WriteBufferMode
     */
    private WriteBufferMode writeBufferMode;

    /**
     * @return the hashType
     */
    public HashType getHashType() {
        return hashType;
    }

    /**
     * @param hashType the hashType to set
     */
    public void setHashType(HashType hashType) {
        this.hashType = hashType;
    }

    /**
     * @return the compressionOptions
     */
    public CompressionOptions getCompressionOptions() {
        return compressionOptions;
    }

    /**
     * @param compressionOptions the compressionOptions to set
     */
    public void setCompressionOptions(CompressionOptions compressionOptions) {
        this.compressionOptions = compressionOptions;
    }

    /**
     * @return the checkSumType
     */
    public CheckSumType getCheckSumType() {
        return checkSumType;
    }

    /**
     * @param checkSumType the checkSumType to set
     */
    public void setCheckSumType(CheckSumType checkSumType) {
        this.checkSumType = checkSumType;
    }

    /**
     * @return the storageHstableSize
     */
    public long getStorageHstableSize() {
        return storageHstableSize;
    }

    /**
     * @param storageHstableSize the storageHstableSize to set
     */
    public void setStorageHstableSize(long storageHstableSize) {
        this.storageHstableSize = storageHstableSize;
    }

    /**
     * @return the storageCompressionAlgorithm
     */
    public String getStorageCompressionAlgorithm() {
        return storageCompressionAlgorithm;
    }

    /**
     * @param storageCompressionAlgorithm the storageCompressionAlgorithm to set
     */
    public void setStorageCompressionAlgorithm(String storageCompressionAlgorithm) {
        this.storageCompressionAlgorithm = storageCompressionAlgorithm;
    }

    /**
     * @return the storageHashingAlgorithm
     */
    public String getStorageHashingAlgorithm() {
        return storageHashingAlgorithm;
    }

    /**
     * @param storageHashingAlgorithm the storageHashingAlgorithm to set
     */
    public void setStorageHashingAlgorithm(String storageHashingAlgorithm) {
        this.storageHashingAlgorithm = storageHashingAlgorithm;
    }

    /**
     * @return the createIfMissing
     */
    public boolean isCreateIfMissing() {
        return createIfMissing;
    }

    /**
     * @param createIfMissing the createIfMissing to set
     */
    public void setCreateIfMissing(boolean createIfMissing) {
        this.createIfMissing = createIfMissing;
    }

    /**
     * @return the errorIfExists
     */
    public boolean isErrorIfExists() {
        return errorIfExists;
    }

    /**
     * @param errorIfExists the errorIfExists to set
     */
    public void setErrorIfExists(boolean errorIfExists) {
        this.errorIfExists = errorIfExists;
    }

    /**
     * @return the writeBufferSize
     */
    public long getWriteBufferSize() {
        return writeBufferSize;
    }

    /**
     * @param writeBufferSize the writeBufferSize to set
     */
    public void setWriteBufferSize(long writeBufferSize) {
        this.writeBufferSize = writeBufferSize;
    }

    /**
     * @return the writeBufferFlushTimeout
     */
    public long getWriteBufferFlushTimeout() {
        return writeBufferFlushTimeout;
    }

    /**
     * @param writeBufferFlushTimeout the writeBufferFlushTimeout to set
     */
    public void setWriteBufferFlushTimeout(long writeBufferFlushTimeout) {
        this.writeBufferFlushTimeout = writeBufferFlushTimeout;
    }

    /**
     * @return the writeBufferMode
     */
    public WriteBufferMode getWriteBufferMode() {
        return writeBufferMode;
    }

    /**
     * @param writeBufferMode the writeBufferMode to set
     */
    public void setWriteBufferMode(WriteBufferMode writeBufferMode) {
        this.writeBufferMode = writeBufferMode;
    }
    
}
