/**
 * @(#)TestCaneKVLogger.java, 2016年11月30日. 
 * 
 * Copyright 2016 zhoukang, Inc. All rights reserved.
 * Use of this source code is governed by the BSD 3-Clause License,
 * that can be found in the LICENSE file.
 */
package cane.kv.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import cane.kv.TestBaseClass;

/**
 *
 * Test {@linkplain CaneKVLogger}
 * @author cane
 *
 */
public class TestCaneKVLogger extends TestBaseClass {
	
	@Test
	public void testLogging() {
		Log log = LogFactory.getLog(TestCaneKVLogger.class);
		log.debug("This is a debug log!");
		log.warn("This is a warn log!");
		log.info("This is a info log!");
		log.error("This is an error log!");
	}

}
