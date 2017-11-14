/*
 * Copyright 2001-2011 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.security.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * @author xzw
 */
public class SecurityUtils {
    /**
     * 用户密码MD5加密后用base64编码.
     * 
     * @param password
     *            需要加密的密码
     * @throws NoSuchAlgorithmException
     *             加密算法在所有的provider都找不到的时候才会出这个异常
     * @throws UnsupportedEncodingException
     *             如果字符转码有问题,就会抛出这个异常
     * @return String 机密后的密码字符串
     */
    public static final String encoderByMd5Base64(String password) {
        MessageDigest md5;
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String newPassword = "";
        try {
            md5 = MessageDigest.getInstance("MD5");
            newPassword = base64Encoder.encode(md5.digest(password.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newPassword;
    }
    
    /**
     * 用户密码MD5加密
     * 
     * @param password
     *            需要加密的密码
     * @throws NoSuchAlgorithmException
     *             加密算法在所有的provider都找不到的时候才会出这个异常
     * @throws UnsupportedEncodingException
     *             如果字符转码有问题,就会抛出这个异常
     * @return String 机密后的密码字符串
     */
    public static final String encoderByMd5(String password) {
        MessageDigest md5;
        StringBuilder newPassword = new StringBuilder("");
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] buf = md5.digest(password.getBytes("UTF-8"));
            String tempString = null;
            for (int i = 0; i < buf.length; i++) {
                tempString = Integer.toHexString(buf[i] & 0xFF);
                if (tempString.length() == 1) {
                    newPassword.append("0");
                }
                newPassword.append(tempString);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newPassword.toString();
    }
    
}
