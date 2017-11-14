/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.mybatishandler;

/**
 * @author xzw.
 * @since 1.0
 * @version 1.0
 */
public class Utils {
    public static String trim(String s) {
        return s.replaceAll("(^[\\u3000\\s]*)", "").replaceAll("([\\u3000\\s]*$)", "");
    }
}