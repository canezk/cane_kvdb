/**
 * @(#)CompressionOptions.java, 2016年12月1日. 
 * 
 * Copyright 2016 zhoukang, Inc. All rights reserved.
 * Use of this source code is governed by the BSD 3-Clause License,
 * that can be found in the LICENSE file.
 */
package cane.kv.options;

/**
 * 数据压缩相关的参数 {@linkplain CompressionType}
 * @author cane
 *
 */
public class CompressionOptions {
    
    /**
     * 数据压缩算法的类型
     */
    private CompressionType compressionType;

    /**
     * @return the compressionType
     */
    public CompressionType getCompressionType() {
        return compressionType;
    }

    /**
     * @param compressionType the compressionType to set
     */
    public void setCompressionType(CompressionType compressionType) {
        this.compressionType = compressionType;
    }
    
    

}
