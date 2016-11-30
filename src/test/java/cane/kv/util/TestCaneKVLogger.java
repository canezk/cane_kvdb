/**
 * @(#)TestCaneKVLogger.java, 2016年11月30日. 
 * 
 * Copyright 2016 Yodao, Inc. All rights reserved.
 * YODAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
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
