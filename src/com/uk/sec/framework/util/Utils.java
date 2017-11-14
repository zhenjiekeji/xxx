/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.context.ApplicationContext;

/**
 * 工具类
 * 
 * @author xzw.
 */
public class Utils {
    
    public static final String WRAP_LEFT  = "left";
    public static final String WRAP_RIGHT = "right";
    public static final String WRAP_BOTH  = "both";
    
    /**
     * 从当前缺省语言的属性文件中获取指定代码值, 缺省值为空字符串
     * 
     * @param key
     *            指定的代码
     * @param args
     *            参数值数组，用于替换代码值中的参数
     * @param appContext
     *            Spring 应用上下文
     * @param log
     *            系统日志
     * @return 代码值
     */
    public static String parsePropertyMessage(String key, Object[] args, ApplicationContext appContext, Log log) {
        return parsePropertyMessage(key, args, Locale.getDefault(), appContext, log);
    }
    
    /**
     * 从指定语言的属性文件中获取指定代码值, 缺省值为空字符串
     * 
     * @param key
     *            指定的属性代码
     * @param args
     *            参数值数组，用于替换代码值中的参数
     * @param locale
     *            本地对象
     * @param appContext
     *            Spring 应用上下文
     * @param log
     *            系统日志
     * @return 代码值
     */
    public static String parsePropertyMessage(String key,
                                              Object[] args,
                                              Locale locale,
                                              ApplicationContext appContext,
                                              Log log) {
        // FIXME: 将参数值编码方式转换为ISO8859-1，与以下读取的 message 格式一致
        Object[] cargs = null;
        if (args != null) {
            cargs = new Object[args.length];
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    continue;
                }
                try {
                    cargs[i] = new String(args[i].toString().getBytes("UTF-8"), "ISO8859-1");
                } catch (UnsupportedEncodingException uee) {
                    if ((log != null) && log.isWarnEnabled()) {
                        log.warn("unsupported UTF-8 Encoding when convert this message: " + args[i], uee);
                    }
                }
            }
        }
        String message = appContext.getMessage(key, cargs, "", locale);
        
        // FIXME: 以下假设各种语言版本的properties文件使用UTF-8编码格式保存，而且没有用native2ascii转换过
        try {
            message = new String(message.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException uee) {
            if ((log != null) && log.isWarnEnabled()) {
                log.warn("unsupported UTF-8 Encoding when convert this message: " + message, uee);
            }
        }
        
        return message;
    }
    
    /**
     * 以config中的key为key,value为策略，在filters中查找对应的value，对value按策略进行%包裹
     * 主要为了解决ibatis的mapper无法配置like的问题
     * 处理PageRequest对象中的filters，对需要使用like关键字的字段，使用%包裹value
     * 
     * @param filters
     *            需要处理的filters
     * @param config
     *            需要进行包裹的字段名，对应filters中的键值
     * @return filters 返回包裹后的filters
     */
    public static Map<String, Object> wrapLikeSymbol(Map<String, Object> filters, Map<String, String> config) {
        for (Iterator<String> iterator = config.keySet().iterator(); iterator.hasNext();) {
            String property = iterator.next();
            if (filters.containsKey(property)) {
                String value = wrap(filters.get(property).toString(), config.get(property));
                filters.put(property, value);
            }
        }
        return filters;
    }
    
    /**
     * 以config中的key为key,value为策略，在filters中查找对应的value，对value按策略进行%包裹
     * 主要为了解决ibatis的mapper无法配置like的问题
     * 处理PageRequest对象中的filters，对需要使用like关键字的字段，清除包裹
     * 
     * @param filters
     *            需要处理的filters
     * @param config
     *            需要清除包裹的字段名，对应filters中的键值
     * @return filters 返回清除包裹后的filters
     */
    public static Map<String, Object> clearWrapLikeSymbol(Map<String, Object> filters, Map<String, String> config) {
        for (Iterator<String> iterator = config.keySet().iterator(); iterator.hasNext();) {
            String property = iterator.next();
            if (filters.containsKey(property)) {
                String value = clearWrap(filters.get(property).toString(), config.get(property));
                filters.put(property, value);
            }
        }
        return filters;
    }
    
    /**
     * 添加开头和结尾的%
     * 
     * @param value
     *            需要包裹的值
     * @param pattern
     *            包裹的策略
     * @return value 包裹之后的值
     */
    private static String wrap(String value, String pattern) {
        if (value.length() == 0 || value == null) {
            return "";
        }
        if (Utils.WRAP_BOTH.equals(pattern) || Utils.WRAP_LEFT.equals(pattern)) {
            value = "%" + value;
        }
        if (Utils.WRAP_BOTH.equals(pattern) || Utils.WRAP_RIGHT.equals(pattern)) {
            value = value + "%";
        }
        return escapeUndercore(value);
    }
    
    /**
     * 去除开头和结尾的%
     * 
     * @param value
     *            包裹的值
     * @param pattern
     *            包裹的策略
     * @return value 去除包裹之后的值
     */
    private static String clearWrap(String value, String pattern) {
        if (value.length() == 0 || value == null) {
            return "";
        }
        if (Utils.WRAP_BOTH.equals(pattern) || Utils.WRAP_LEFT.equals(pattern)) {
            value = value.substring(1);
        }
        if (Utils.WRAP_BOTH.equals(pattern) || Utils.WRAP_RIGHT.equals(pattern)) {
            value = value.substring(0, value.length() - 1);
        }
        return clearEscapeUndercore(value);
    }
    
    /**
     * 包裹后处理_的转义问题
     * 
     * @param value
     *            需要转义的值
     * @return value 转义之后的值
     */
    private static String escapeUndercore(String value) {
        if (value.contains("_")) {
            return value.replaceAll("_", "\\\\_");
        } else {
            return value;
        }
    }
    
    /**
     * 清除_的转义
     * 
     * @param value
     *            转义的值
     * @return value 清除转义之后的值
     */
    private static String clearEscapeUndercore(String value) {
        if (value.contains("\\_")) {
            return value.replaceAll("\\\\_", "_");
        } else {
            return value;
        }
    }
    
    public static String formatDecimal(String pattern, double number) {
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(number);
    }
    
    /**
     * 将对象装换成json串输出.
     * 
     * @param o
     * @return json串.
     * @author xzw.
     */
    public static String objectToJson(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        SerializationConfig sc = mapper.getSerializationConfig();
        mapper.setSerializationConfig(sc);
        StringWriter sw = new StringWriter();
        JsonGenerator gen;
        try {
            gen = new JsonFactory().createJsonGenerator(sw);
            mapper.writeValue(gen, o);
            gen.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
}
