/**
 * @(#)CompressionType.java, 2016年11月30日. 
 * 
 * Copyright 2016 zhoukang, Inc. All rights reserved.
 * Use of this source code is governed by the BSD 3-Clause License,
 * that can be found in the LICENSE file.
 */
package cane.kv.options;

/**
 * 压缩算法类型
 * @author cane
 *
 */
public enum CompressionType {
	NOCOMPRESSION(0),
	LZ4COMPRESSION(1);
	
	private int type;
        
        private CompressionType(int t) {
            this.type = t;
        }
        
        public int getType() {
            return this.type;
        }
	
}
