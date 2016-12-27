/**
 * @(#)CaneKVFileUtils.java, 2016年12月1日. 
 * 
 * Copyright 2016 zhoukang, Inc. All rights reserved.
 * Use of this source code is governed by the BSD 3-Clause License,
 * that can be found in the LICENSE file.
 */
package cane.kv.util;

/**
 * 和文件系统交互的类
 * @author cane
 *
 */
public class CaneKVFileUtils {

    /**
     * 获取当前目录的绝对路径
     * @return
     */
    public static String getCwd() {
        return System.getProperty("user.dir");
    }
    
}
