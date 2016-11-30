/**
 * @(#)WriteBufferMode.java, 2016年11月30日. 
 * 
 * Copyright 2016 Yodao, Inc. All rights reserved.
 * YODAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
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
