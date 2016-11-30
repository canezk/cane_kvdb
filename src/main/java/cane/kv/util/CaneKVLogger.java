/**
 * @(#)CaneKVLogger.java, 2016年11月30日. 
 * 
 * Copyright 2016 Yodao, Inc. All rights reserved.
 * YODAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cane.kv.util;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.xml.DOMConfigurator;

/**
 * 日志模块使用 {@linkplain Logger} 实现
 * @author cane
 *
 */
public class CaneKVLogger {

	/**
	 * 读取日志配置文件
	 */
    public static void init() {
        String logPath = "/conf/log4j.xml";
        String workPath = System.getProperty("user.dir");
        Path logFullPath = Paths.get(workPath, logPath);
        System.out.printf("Log Path is %s\n", logFullPath.toString());
        DOMConfigurator.configure(logFullPath.toString());
    }
}
