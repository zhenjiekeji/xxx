/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.system.action;

import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.uk.sec.framework.base.BaseStruts2Action;
import com.uk.sec.framework.system.model.SecSysRulevalue;
import com.uk.sec.framework.system.model.SecSysSeqrule;
import com.uk.sec.framework.system.service.SecSysRulevalueManager;
import com.uk.sec.framework.system.service.SecSysSeqruleManager;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class SecSysSeqruleAction extends BaseStruts2Action implements Preparable, ModelDriven {
    /**
     * 默认多列排序,example: username desc,createTime asc.
     */
    protected static final String  DEFAULT_SORT_COLUMNS = null;
    /*
     * 跳转地址.---------------START---------------
     */
    /**
     * 查询页面.
     */
    protected static final String  QUERY_JSP            = "/framework/system/SecSysSeqrule/query.jsp";
    /**
     * 列表页面.
     */
    protected static final String  LIST_JSP             = "/framework/system/SecSysSeqrule/list.jsp";
    /**
     * 新建页面.
     */
    protected static final String  CREATE_JSP           = "/framework/system/SecSysSeqrule/create.jsp";
    /**
     * 编辑页面.
     */
    protected static final String  EDIT_JSP             = "/framework/system/SecSysSeqrule/edit.jsp";
    /**
     * 查看页面.
     */
    protected static final String  SHOW_JSP             = "/framework/system/SecSysSeqrule/show.jsp";
    /*
     * 跳转地址.---------------E N D---------------
     */

    /*
     * 重定向地址以!开头.---------------START---------------
     */
    /**
     * LIST_ACTION 跳转到列表页面.
     */
    protected static final String  LIST_ACTION          = "!/framework/system/SecSysSeqrule/list.do" + NOTIFY_STATE;
    /*
     * 重定向地址以!开头.---------------E N D---------------
     */

    /*
     * 内部成员定义.---------------START---------------
     */
    /**
     * manager.
     */
    private SecSysSeqruleManager   secSysSeqruleManager;
    private SecSysRulevalueManager secSysRulevalueManager;
    /**
     * model.
     */
    private SecSysSeqrule          secSysSeqrule;
    private SecSysRulevalue        secSysRulevalue;
    /**
     * id.
     */
    java.lang.String               id                   = null;
    /**
     * items 删除记录id数组.
     */
    private String[]               items;
    
    /*
     * 内部成员定义.---------------E N D---------------
     */

    /**
     * {@inheritDoc}
     * 
     * @see com.opensymphony.xwork2.Preparable#prepare()
     */
    public void prepare() throws Exception {
        if (isNullOrEmptyString(id)) {
            secSysSeqrule = new SecSysSeqrule();
        } else {
            secSysSeqrule = secSysSeqruleManager.getById(id);
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public Object getModel() {
        return secSysSeqrule;
    }
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
     * 
     * @param manager
     *            manager.
     */
    public void setSecSysSeqruleManager(SecSysSeqruleManager manager) {
        this.secSysSeqruleManager = manager;
    }
    
    /**
     * @param val
     *            id.
     */
    public void setRuleId(java.lang.String val) {
        this.id = val;
    }
    
    /**
     * @param items
     *            items.
     */
    public void setItems(String[] items) {
        this.items = items;
    }
    
    /**
     * 进入查询页面.
     * 
     * @return 查询页面.
     */
    public String query() {
        return QUERY_JSP;
    }
    
    /**
     * 执行搜索.
     * 
     * @return 搜索页面.
     */
    public String list() {
        PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
        // pageRequest.getFilters().put("key",value); //add custom filter
        Page page = secSysSeqruleManager.findByPageRequest(pageRequest);
        savePage(page, pageRequest);
        return LIST_JSP;
    }
    
    /**
     * 查看对象.
     * 
     * @return 查看页面.
     */
    public String show() {
        return SHOW_JSP;
    }
    
    /**
     * 进入新增页面
     * 
     * @return 新增页面.
     */
    public String create() {
        return CREATE_JSP;
    }
    
    /**
     * 保存新增对象.
     * 
     * @return 重定向到列表页面.
     */
    public String save() {
        secSysSeqruleManager.save(secSysSeqrule);
        
        return LIST_ACTION;
    }
    
    /**
     * 根据String ruleEname, String ruleKeyvalue)
     * 
     * @return seqCurrentvalue. 每次 seqCurrentvalue取得后 都要在存入最新的 供下一次使用
     */
    public long getSeqRuleValue(String ruleEname, String ruleKeyvalue) {
        long seqCurrentvalue = 0;
        secSysSeqrule = secSysSeqruleManager.findByProperty("ruleEname", ruleEname);
        if (secSysSeqrule != null) {
            secSysRulevalue = secSysRulevalueManager.findByProperty("ruleKeyvalue", ruleKeyvalue);
            if (secSysRulevalue != null) {
                seqCurrentvalue = secSysRulevalue.getSeqCurrentvalue();
                
                long newseqCurrentvalue = seqCurrentvalue + secSysSeqrule.getSeqStep();
                double max = Math.pow(10, secSysSeqrule.getSeqLength()) - 1;
                
                if (newseqCurrentvalue < max) {
                    secSysRulevalue.setSeqCurrentvalue(seqCurrentvalue + secSysSeqrule.getSeqStep());
                    secSysRulevalueManager.update(secSysRulevalue);
                } else
                    return Long.MAX_VALUE;
                
            }
        }
        
        return seqCurrentvalue;
    }
    
    /**
     * 根据String ruleKeyvalue,SecSysSeqrule,对于不满足的条件的返回MAX
     * 
     * @return 查找一个对应SecSysSeqrule 的值 seqCurrentvalue
     */
    public long getSeqValue(SecSysSeqrule secSysSeqrule, String ruleKeyvalue) {
        long seqCurrentvalue = 0;
        if (secSysSeqrule != null) {
            secSysRulevalue = secSysRulevalueManager.findByProperty("ruleKeyvalue", ruleKeyvalue);
            if (secSysRulevalue != null) {
                seqCurrentvalue = secSysRulevalue.getSeqCurrentvalue();
                
                long newseqCurrentvalue = seqCurrentvalue + secSysSeqrule.getSeqStep();
                double max = Math.pow(10, secSysSeqrule.getSeqLength()) - 1;
                
                if (newseqCurrentvalue < max) {
                    secSysRulevalue.setSeqCurrentvalue(seqCurrentvalue + secSysSeqrule.getSeqStep());
                    secSysRulevalueManager.update(secSysRulevalue);
                } else
                    return Long.MAX_VALUE;
                
            }
        }
        
        return seqCurrentvalue;
    }
    
    /**
     * 根据String ruleEname,
     * 
     * @return 查找一个secSysSeqrule 规则
     */
    public SecSysSeqrule getSeqRule(String ruleEname) {
        secSysSeqrule = secSysSeqruleManager.findByProperty("ruleEname", ruleEname);
        return secSysSeqrule;
    }
    
    /**
     * 根据String ruleEname, String ruleKeyvalue)
     * 
     * @return seqCurrentvalue. 每次 seqCurrentvalue取得后 都要在存入最新的 供下一次使用
     * @param 注意this
     */
    public boolean saveFirstCreate(SecSysRulevalue secSysRulevalue, SecSysSeqrule secSysSeqrule) {
        
        this.secSysSeqrule = secSysSeqruleManager.findByProperty("ruleEname", secSysSeqrule.getRuleEname());
        if (this.secSysSeqrule == null) {
            secSysSeqruleManager.save(secSysSeqrule);
            secSysSeqrule = secSysSeqruleManager.findByProperty("ruleEname", secSysSeqrule.getRuleEname());
            secSysRulevalue.setRuleId(secSysSeqrule.getRuleId());
            secSysRulevalueManager.save(secSysRulevalue);
            
        } else {
            this.secSysRulevalue = secSysRulevalueManager.findByProperty("ruleKeyvalue",
                                                                         secSysRulevalue.getRuleKeyvalue());
            if (this.secSysRulevalue == null) {
                secSysRulevalue.setRuleId(this.secSysSeqrule.getRuleId());
                secSysRulevalueManager.save(secSysRulevalue);
            } else
                return false;
            
        }
        
        return true;
    }
    
    /**
     * 进入更新页面.
     * 
     * @return 更新页面.
     */
    public String edit() {
        return EDIT_JSP;
    }
    
    /**
     * 保存更新对象.
     * 
     * @return 重定向到列表页面.
     */
    public String update() {
        secSysSeqruleManager.update(this.secSysSeqrule);
        return LIST_ACTION;
    }
    
    /**
     * 删除对象.
     * 
     * @return 重定向到列表页面.
     */
    public String delete() {
        for (int i = 0; i < items.length; i++) {
            Hashtable params = HttpUtils.parseQueryString(items[i]);
            java.lang.String id = new java.lang.String((String) params.get("ruleId"));
            secSysSeqruleManager.removeById(id);
        }
        return LIST_ACTION;
    }
    
    /**
     * 删除对象.
     * 
     * @return 重定向到列表页面.
     */
    public String deleteById() {
        if (StringUtils.isNotBlank(id)) {
            secSysSeqruleManager.removeById(id);
        }
        return LIST_ACTION;
    }
    
    @Override
    public String getEctableId() {
        return "SecSysSeqrule_list";
    }
    
    public SecSysRulevalueManager getSecSysRulevalueManager() {
        return secSysRulevalueManager;
    }
    
    public void setSecSysRulevalueManager(SecSysRulevalueManager secSysRulevalueManager) {
        this.secSysRulevalueManager = secSysRulevalueManager;
    }
    
    public SecSysRulevalue getSecSysRulevalue() {
        return secSysRulevalue;
    }
    
    public void setSecSysRulevalue(SecSysRulevalue secSysRulevalue) {
        this.secSysRulevalue = secSysRulevalue;
    }
    
}
