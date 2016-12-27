/**
 * @(#)KVException.java, 2016年12月2日. 
 * 
 * Copyright 2016 zhoukang, Inc. All rights reserved.
 * Use of this source code is governed by the BSD 3-Clause License,
 * that can be found in the LICENSE file.
 */
package cane.kv.interfaces;

import java.util.HashMap;
import java.util.Map;

/**
 * 继承自{@linkplain Exception},作为{@linkplain DataBase}
 * 抛出的Checked Exception基类
 * @author cane
 *
 */
public abstract class KVException extends Exception {
    
    public static enum Code {
        /**
         * Everything is ok
         */
        OK(0),
        
        /**
         * key,entry等在数据存储引擎中不存在
         */
        NOTFOUND(1),
        
        /**
         * 文件系统io相关错误
         */
        IOERROR(3);
        
        private static final Map<Integer, Code> lookup =
                new HashMap<Integer, Code>();
        static {
            for(Code code : Code.values()) {
                lookup.put(code.intValue(), code);
            }
        }
        
        private int code;
        private Code(int code) {
            this.code = code;
        }
        
        /**
         * 获取Code对应的整数码
         * @return
         */
        public int intValue() {
            return this.code;
        }
        
        /**
         * 根据整数返回 {@linkplain Code}
         * @param code
         * @return
         */
        public static Code getCodeByInt(int code) {
            return lookup.get(code);
        }
    }
    
    static String getCodeMessage(Code code) {
        switch (code) {
            case OK:
                return "ok";
                
            case NOTFOUND:
                return "Not found: ";
                
            case IOERROR:
                return "IO error: ";

            default:
                return "Unknown error:" + code;
        }
    }
    
    /**
     * @see KVException#Create(Code)
     * @param code
     * @param errorString - 详细的消息体
     * @return
     */
    public static KVException Create(Code code, String errorString) {
        KVException kvException = Create(code);
        kvException.errorString = errorString;
        return kvException;
    }
    
    /**
     * 工厂方法，用于创建指定类型的exception;
     * 如果调用方api知道exception的类型，那么就直接new指定类型的
     * 
     * @param code - 需要创建的异常类型对应的 {@linkplain Code}
     * @return 指定类型的exception
     */
    public static KVException Create(Code code) {
        switch (code) {
            case NOTFOUND:
                return new NotFoundException();
                
            case IOERROR:
                return new IOErrorException();

            case OK:
            default:
                throw new IllegalArgumentException("Invalid exception code");
        }
    }
    
    private Code code;
    private String errorString;
    
    public KVException(Code code) {
        this.code = code;
        this.errorString = null;
    }
    
    public KVException(Code code, String errorString) {
        this.errorString = errorString;
    }
    
    public Code code() {
        return code;
    }
    
    public String getMessage() {
        if(errorString == null) {
            return "KVException:" + getCodeMessage(code);
        }
        return "KVException:" + getCodeMessage(code) + " with error " + errorString;
    }
    
    /**
     * @see Code#NOTFOUND
     *
     */
    @SuppressWarnings("serial")
    public static class NotFoundException extends KVException {
       public NotFoundException() {
           super(Code.NOTFOUND);
       }
       
       public NotFoundException(String errorString) {
           super(Code.NOTFOUND, errorString);
       }
    }
    
    /**
     * @see Code#IOERROR
     *
     */
    @SuppressWarnings("serial")
    public static class IOErrorException extends KVException {
        public IOErrorException() {
            super(Code.IOERROR);
        }
        
        public IOErrorException(String errorString) {
            super(Code.IOERROR, errorString);
        }
    }
}
