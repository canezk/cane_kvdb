/**
 * @(#)WriteBufferMode.java, 2016年11月30日. 
 * 
 * Copyright 2016 zhoukang, Inc. All rights reserved.
 * Use of this source code is governed by the BSD 3-Clause License,
 * that can be found in the LICENSE file.
 */
package cane.kv.options;

/**
 * Buffer持久化到磁盘的策略
 * @author cane
 *
 */
public enum WriteBufferMode {
	WRITEBUFFERMODEDIRECT,
	WRITEBUFFERMODEADAPTIVE

}
