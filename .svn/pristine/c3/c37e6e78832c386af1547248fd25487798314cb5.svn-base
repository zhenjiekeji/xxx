/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.action;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.uk.sec.framework.base.BaseStruts2Action;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicGroup;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicItem;
import com.uk.sec.privilege.framework.privilege.service.SecBasDicGroupManager;
import com.uk.sec.privilege.framework.privilege.service.SecBasDicItemManager;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class SecBasDicItemAction extends BaseStruts2Action implements Preparable, ModelDriven {
    /**
     * 默认多列排序,example: username desc,createTime asc.
     */
    protected static final String DEFAULT_SORT_COLUMNS = null;
    /*
     * 跳转地址.---------------START---------------
     */
    /**
     * 查询页面.
     */
    protected static final String QUERY_JSP            = "/framework/privilege/SecBasDicItem/query.jsp";
    /**
     * 列表页面.
     */
    protected static final String LIST_JSP             = "/framework/privilege/SecBasDicItem/list.jsp";
    /**
     * 新建页面.
     */
    protected static final String CREATE_JSP           = "/framework/privilege/SecBasDicItem/create.jsp";
    /**
     * 编辑页面.
     */
    protected static final String EDIT_JSP             = "/framework/privilege/SecBasDicItem/edit.jsp";
    /**
     * 查看页面.
     */
    protected static final String SHOW_JSP             = "/framework/privilege/SecBasDicItem/show.jsp";
    /*
     * 跳转地址.---------------E N D---------------
     */

    /*
     * 重定向地址以!开头.---------------START---------------
     */
    /**
     * LIST_ACTION 跳转到列表页面.
     */
    protected static final String LIST_ACTION          = "!/framework/privilege/SecBasDicItem/list.do" + NOTIFY_STATE;
    /*
     * 重定向地址以!开头.---------------E N D---------------
     */

    /*
     * 内部成员定义.---------------START---------------
     */
    /**
     * manager.
     */
    private SecBasDicItemManager  secBasDicItemManager;
    private SecBasDicGroupManager secBasDicGroupManager;
    /**
     * model.
     */
    private SecBasDicItem         secBasDicItem;
    private List<SecBasDicItem>   dicItemList;
    /**
     * id.
     */
    java.lang.String              id                   = null;
    /**
     * items 删除记录id数组.
     */
    private String[]              items;
    private String                groupId;
    
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
            secBasDicItem = new SecBasDicItem();
        } else {
            secBasDicItem = secBasDicItemManager.getById(id);
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public Object getModel() {
        return secBasDicItem;
    }
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
     * 
     * @param manager
     *            manager.
     */
    public void setSecBasDicItemManager(SecBasDicItemManager manager) {
        this.secBasDicItemManager = manager;
    }
    
    public void setSecBasDicGroupManager(SecBasDicGroupManager secBasDicGroupManager) {
        this.secBasDicGroupManager = secBasDicGroupManager;
    }
    
    /**
     * @param val
     *            id.
     */
    public void setDicId(java.lang.String val) {
        this.id = val;
    }
    
    /**
     * @param items
     *            items.
     */
    public void setItems(String[] items) {
        this.items = items;
    }
    
    public String getGroupId() {
        return groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    public List<SecBasDicItem> getDicItemList() {
        return dicItemList;
    }
    
    public void setDicItemList(List<SecBasDicItem> dicItemList) {
        this.dicItemList = dicItemList;
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
    @SuppressWarnings("unchecked")
    public String list() {
        SecBasDicGroup secBasDicGroup = null;
        PageRequest<Map> pageRequest = newPageRequest("ITEM_ORDER");
        if (this.groupId != null && !isNullOrEmptyString(this.groupId)) {
            pageRequest.getFilters().put("groupId", this.groupId); // 按分组名称查询字典项
            secBasDicGroup = findDicGroupById(this.groupId);
            this.getRequest().setAttribute("DicGroupId", this.groupId);
            // 获取最大和最小排序列
            Long itemOrder = secBasDicItemManager.findMaxItemOrder(this.groupId);
            if (itemOrder != null && itemOrder > 1) {
                this.getRequest().setAttribute("maxItemOrder", itemOrder - 1);
            } else {
                this.getRequest().setAttribute("maxItemOrder", 1);
            }
            
            Long minItemOrder = secBasDicItemManager.findMinItemOrder(this.groupId);
            if (minItemOrder != null && minItemOrder > 0) {
                this.getRequest().setAttribute("minItemOrder", minItemOrder);
            } else {
                this.getRequest().setAttribute("minItemOrder", 1);
            }
        }
        
        if (!isNullOrEmptyString(secBasDicGroup)) {
            this.getRequest().setAttribute("DicGroupName", secBasDicGroup.getGroupName());
        }
        
        Page page = secBasDicItemManager.findByPageRequest(pageRequest);
        savePage(page, pageRequest);
        
        return LIST_JSP;
    }
    
    public SecBasDicGroup findDicGroupById(String groupId) {
        return secBasDicGroupManager.findByProperty("groupId", groupId);
    }
    
    /**
     * 查看对象.
     * 
     * @return 查看页面.
     */
    public String show() {
        if (this.groupId != null) {
            SecBasDicGroup secBasDicGroup = findDicGroupById(this.groupId);
            this.getRequest().setAttribute("DicGroupId", this.groupId);
            if (!isNullOrEmptyString(secBasDicGroup)) {
                this.getRequest().setAttribute("DicGroupName", secBasDicGroup.getGroupName());
            }
        }
        return SHOW_JSP;
    }
    
    /**
     * 进入新增页面
     * 
     * @return 新增页面.
     */
    public String create() {
        if (this.groupId != null) {
            SecBasDicGroup secBasDicGroup = findDicGroupById(this.groupId);
            this.getRequest().setAttribute("DicGroupId", this.groupId);
            if (!isNullOrEmptyString(secBasDicGroup)) {
                this.getRequest().setAttribute("DicGroupName", secBasDicGroup.getGroupName());
            }
        }
        return CREATE_JSP;
    }
    
    /**
     * 保存新增对象.
     * 
     * @return 重定向到列表页面.
     */
    public String save() {
        Long itemId = secBasDicItemManager.findMaxItemId(this.groupId);
        Long itemOrder = secBasDicItemManager.findMaxItemOrder(this.groupId);
        
        secBasDicItem.setItemId(itemId);
        secBasDicItem.setItemOrder(itemOrder);
        
        secBasDicItemManager.save(secBasDicItem);
        
        return "!/framework/privilege/SecBasDicItem/list.do?groupId=" + this.groupId;
        // return LIST_ACTION;
    }
    
    /**
     * 进入更新页面.
     * 
     * @return 更新页面.
     */
    public String edit() {
        if (this.groupId != null) {
            SecBasDicGroup secBasDicGroup = findDicGroupById(this.groupId);
            this.getRequest().setAttribute("DicGroupId", this.groupId);
            if (!isNullOrEmptyString(secBasDicGroup)) {
                this.getRequest().setAttribute("DicGroupName", secBasDicGroup.getGroupName());
            }
        }
        return EDIT_JSP;
    }
    
    /**
     * 保存更新对象.
     * 
     * @return 重定向到列表页面.
     */
    public String update() {
        secBasDicItemManager.update(this.secBasDicItem);
        return "!/framework/privilege/SecBasDicItem/list.do?groupId=" + secBasDicItem.getGroupId();
    }
    
    /**
     * 删除对象.
     * 
     * @return 重定向到列表页面.
     */
    public String delete() {
        for (int i = 0; i < items.length; i++) {
            Hashtable params = HttpUtils.parseQueryString(items[i]);
            java.lang.String id = new java.lang.String((String) params.get("dicId"));
            this.secBasDicItem = secBasDicItemManager.getById(id);
            secBasDicItem.setItemFlag(secBasDicItem.ITEM_FLAG_INVISIBLE);
            secBasDicItemManager.update(secBasDicItem);
        }
        return "!/framework/privilege/SecBasDicItem/list.do?groupId=" + secBasDicItem.getGroupId();
    }
    
    /**
     * 删除对象.
     * 
     * @return 重定向到列表页面.
     */
    public String deleteById() {
        if (StringUtils.isNotBlank(id)) {
            this.secBasDicItem = secBasDicItemManager.getById(id);
            secBasDicItem.setItemFlag(secBasDicItem.ITEM_FLAG_INVISIBLE);
            secBasDicItemManager.update(secBasDicItem);
        }
        return "!/framework/privilege/SecBasDicItem/list.do?groupId=" + secBasDicItem.getGroupId();
    }
    
    public String orderUp() {
        if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(this.groupId)) {
            secBasDicItemManager.orderUp(id, groupId);
        }
        return "!/framework/privilege/SecBasDicItem/list.do?groupId=" + this.groupId;
    }
    
    public String orderDown() {
        if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(this.groupId)) {
            secBasDicItemManager.orderDown(id, groupId);
        }
        return "!/framework/privilege/SecBasDicItem/list.do?groupId=" + this.groupId;
    }
    
    @Override
    public String getEctableId() {
        return "SecBasDicItem_list";
    }
}
