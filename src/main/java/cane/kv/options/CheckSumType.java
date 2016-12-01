/**
 * @(#)CheckSumType.java, 2016年11月30日. 
 * 
 * Copyright 2016 zhoukang, Inc. All rights reserved.
 * Use of this source code is governed by the BSD 3-Clause License,
 * that can be found in the LICENSE file.
 */
package cane.kv.options;

/**
 * 计算校验和的算法类型
 * @author cane
 *
 */
public enum CheckSumType {
	NOCHECKSUM(0),
	CRC32C(1);
	
	private int type;
	
	private CheckSumType(int t) {
	    this.type = t;
	}
	
	public int getType() {
	    return this.type;
	}

}
