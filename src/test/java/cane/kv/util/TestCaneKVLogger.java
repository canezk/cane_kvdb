/**
 * @(#)TestCaneKVLogger.java, 2016年11月30日. 
 * 
 * Copyright 2016 zhoukang, Inc. All rights reserved.
 * Use of this source code is governed by the BSD 3-Clause License,
 * that can be found in the LICENSE file.
 */
package cane.kv.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		Logger log = LoggerFactory.getLogger(TestCaneKVLogger.class);
		log.debug("This is a debug log {}!", "cane");
		log.warn("This is a warn log {}!", "cane");
		log.info("This is a info log {}!", "cane");
		log.error("This is an error log {}!", "cane");
	}

}
