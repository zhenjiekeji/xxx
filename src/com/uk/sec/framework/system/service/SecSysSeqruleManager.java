/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.system.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.base.EntityDao;
import com.uk.sec.framework.system.dao.SecSysSeqruleDao;
import com.uk.sec.framework.system.model.SecSysSeqrule;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

@Component
@Transactional
public class SecSysSeqruleManager extends BaseManager<SecSysSeqrule, java.lang.String> {
    /**
     * historyDao
     */
    private SecSysSeqruleDao secSysSeqruleDao;
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     * 
     * @param dao
     *            dao.
     */
    public void setSecSysSeqruleDao(SecSysSeqruleDao dao) {
        this.secSysSeqruleDao = dao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#getEntityDao()
     */
    @Override
    public EntityDao getEntityDao() {
        return this.secSysSeqruleDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    @Override
    @Transactional(readOnly = true)
    public Page findByPageRequest(PageRequest pr) {
        return secSysSeqruleDao.findByPageRequest(pr);
    }
    
    /**
     * 000 前缀生成
     */
    public static Map<Integer, String> createPrefix(long maxLength) {
        
        Map<Integer, String> Prefix = new HashMap<Integer, String>();
        String prefix = "";
        for (int i = 1; i < maxLength; i++) {
            prefix += "0";
            Prefix.put(i, prefix);
        }
        return Prefix;
        
    }
    
    public static String getPrefixCode(String Str, long maxLength) {
        
        Map<Integer, String> PrefixMap = createPrefix(maxLength);
        int num = Integer.parseInt(Str);
        String prefix = null;
        for (int i = 1; i < maxLength; i++) {
            double max = Math.pow(10, i);
            prefix = PrefixMap.get((int) (maxLength - i));
            if (num > max) {
                Str = null;
                continue;
            } else {
                Str = prefix + num;
                return Str;
            }
        }
        if (Str == null)
            return num + "";
        return Str;
    }
}
