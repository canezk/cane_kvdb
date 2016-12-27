/**
 * @(#)CaneKVDB.java, 2016年12月3日. 
 * 
 * Copyright 2016 zhoukang, Inc. All rights reserved.
 * Use of this source code is governed by the BSD 3-Clause License,
 * that can be found in the LICENSE file.
 */
package cane.kv.interfaces;

import java.io.IOException;

/**
 * Abstract class for {@linkplain DataBase} and {@linkplain Snapshot}
 * 定义了一些基本操作数据库的api
 * @author cane
 *
 */
public abstract class CaneKVDB {

    public abstract void open() throws KVException, IOException;
}
