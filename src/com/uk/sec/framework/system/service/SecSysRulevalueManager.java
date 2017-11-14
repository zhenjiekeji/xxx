/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.system.service;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.base.EntityDao;
import com.uk.sec.framework.system.dao.SecSysRulevalueDao;
import com.uk.sec.framework.system.model.SecSysRulevalue;
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
public class SecSysRulevalueManager extends BaseManager<SecSysRulevalue, java.lang.String> {
    /**
     * historyDao
     */
    private SecSysRulevalueDao secSysRulevalueDao;
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     * 
     * @param dao
     *            dao.
     */
    public void setSecSysRulevalueDao(SecSysRulevalueDao dao) {
        this.secSysRulevalueDao = dao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#getEntityDao()
     */
    @Override
    public EntityDao getEntityDao() {
        return this.secSysRulevalueDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    @Override
    @Transactional(readOnly = true)
    public Page findByPageRequest(PageRequest pr) {
        return secSysRulevalueDao.findByPageRequest(pr);
    }
    
    /**
     * 根据String ruleEname, rule id 2个条件过滤
     * 
     * @return 获得一个生成后的id
     */
    public String createValue() {
        
        return null;
        
    }
    
    /**
     * 根据String ruleKeyvalue,SecSysSeqrule
     * 
     * @return 查找一个对应SecSysSeqrule 的值 seqCurrentvalue
     */
    public long getSeqValue(SecSysSeqrule secSysSeqrule, String ruleKeyvalue) {
        long seqCurrentvalue = 0;
        
        SecSysRulevalue secSysRulevalue = this.getSeqRule(ruleKeyvalue, secSysSeqrule);
        // 查到了,存入新值 验证是否大于最大值 否则要 创建新的
        if (secSysRulevalue != null) {
            seqCurrentvalue = secSysRulevalue.getSeqCurrentvalue();
            
            long newseqCurrentvalue = seqCurrentvalue + secSysSeqrule.getSeqStep();
            double max = Math.pow(10, secSysSeqrule.getSeqLength()) - 1;
            
            if (newseqCurrentvalue < max) {
                
                secSysRulevalue.setSeqCurrentvalue(seqCurrentvalue + secSysSeqrule.getSeqStep());
                this.update(secSysRulevalue);
            } else {
                System.out.println("不能增加");
                return Long.MAX_VALUE;
            }
        } else {
            seqCurrentvalue = secSysSeqrule.getSeqStartvalue();
            String temp = secSysSeqrule.getRuleId();
            secSysRulevalue = new SecSysRulevalue();
            secSysRulevalue.setRuleId(temp);
            secSysRulevalue.setRuleKeyvalue(ruleKeyvalue);
            // long 型相加 ,数据库
            secSysRulevalue.setSeqCurrentvalue(secSysSeqrule.getSeqStartvalue() + secSysSeqrule.getSeqStep());
            
            this.save(secSysRulevalue);
        }
        
        return seqCurrentvalue;
    }
    
    /**
     * 生产单号 code(4 位) YP 2012 0001
     * 
     * @return 新增页面.
     */
    public String createIndentCode(String ruleKeyvalue, long seqCurrentvalue, long maxLength) {
        
        String seqCurrentvalueStr = getFormatStr(seqCurrentvalue + "", maxLength);
        
        return ruleKeyvalue + seqCurrentvalueStr;
    }
    
    /**
     * 生成 规则的 key
     * 
     * @return 新增页面.
     */
    public String createRuleKeyvalue(String deptId, String codeName, long maxLength) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        
        deptId = getFormatStr(deptId, maxLength);
        
        return deptId + codeName + year;
    }
    
    /**
     * 左边自动补零方法(流水号)
     * 
     * @param beforeFormatStr
     * @param maxLength
     * @return
     */
    private String getFormatStr(String beforeFormatStr, long Length) {
        int beforeFormatNum = Integer.parseInt(beforeFormatStr);
        int maxLength = (int) Length;
        // 得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        // 设置是否使用分组
        nf.setGroupingUsed(false);
        // 设置最大整数位数
        nf.setMaximumIntegerDigits(maxLength);
        // 设置最小整数位数
        nf.setMinimumIntegerDigits(maxLength);
        return nf.format(beforeFormatNum);
    }
    
    /**
     * 根据String ruleEname, rule id 2个条件过滤
     * 
     * @return 查找一个SecSysRulevalue
     */
    public SecSysRulevalue getSeqRule(String ruleKeyvalue, SecSysSeqrule secSysSeqrule) {
        Map param = new HashMap();
        param.put("ruleKeyvalue", ruleKeyvalue);
        param.put("ruleId", secSysSeqrule.getRuleId());
        List<SecSysRulevalue> list = this.findAllBy(param);
        if (list != null && list.size() > 0)
            return list.get(0);
        else
            return null;
        
    }
}
