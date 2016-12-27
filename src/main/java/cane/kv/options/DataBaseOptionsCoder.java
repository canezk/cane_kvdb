/**
 * @(#)DataBaseOptionsCoder.java, 2016年12月27日. 
 * 
 * Copyright 2016 zhoukang, Inc. All rights reserved.
 * Use of this source code is governed by the BSD 3-Clause License,
 * that can be found in the LICENSE file.
 */
package cane.kv.options;

import java.nio.MappedByteBuffer;

import cane.kv.interfaces.KVException;

/**
 *
 * @author cane
 *
 */
public class DataBaseOptionsCoder {
    
    /**
     * 将buffer的信息解码存储到options中 {@linkplain DataBaseOptions}
     * @param buffer 配置文件buffer
     * @param size buffer可读大小
     * @param options 需要初始化的 {@linkplain DataBaseOptions}
     * @throws KVException
     */
    public static void decodeFrom(MappedByteBuffer buffer, long size, DataBaseOptions options)
            throws KVException {
        
    }

}
