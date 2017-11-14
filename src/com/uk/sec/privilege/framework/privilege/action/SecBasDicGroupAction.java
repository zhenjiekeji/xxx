/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.action;

import java.util.ArrayList;
import java.util.HashMap;
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

public class SecBasDicGroupAction extends BaseStruts2Action implements Preparable, ModelDriven {
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
    protected static final String QUERY_JSP            = "/framework/privilege/SecBasDicGroup/query.jsp";
    /**
     * 列表页面.
     */
    protected static final String LIST_JSP             = "/framework/privilege/SecBasDicGroup/list.jsp";
    /**
     * 新建页面.
     */
    protected static final String CREATE_JSP           = "/framework/privilege/SecBasDicGroup/create.jsp";
    /**
     * 编辑页面.
     */
    protected static final String EDIT_JSP             = "/framework/privilege/SecBasDicGroup/edit.jsp";
    /**
     * 查看页面.
     */
    protected static final String SHOW_JSP             = "/framework/privilege/SecBasDicGroup/show.jsp";
    
    /**
     * 所有分组tree
     */
    protected static final String GROUP_LIST_JSP       = "/framework/privilege/SecBasDicGroup/dicGroupTree.jsp";
    
    protected static final String ITEM_GROUP_LIST_JSP  = "/framework/privilege/SecBasDicItem/dicItemForm.jsp";
    
    /*
     * 跳转地址.---------------E N D---------------
     */

    /*
     * 重定向地址以!开头.---------------START---------------
     */
    /**
     * LIST_ACTION 跳转到列表页面.
     */
    protected static final String LIST_ACTION          = "!/framework/privilege/SecBasDicGroup/list.do" + NOTIFY_STATE;
    /*
     * 重定向地址以!开头.---------------E N D---------------
     */

    /*
     * 内部成员定义.---------------START---------------
     */
    /**
     * manager.
     */
    private SecBasDicGroupManager secBasDicGroupManager;
    private SecBasDicItemManager  secBasDicItemManager;
    /**
     * model.
     */
    private SecBasDicGroup        secBasDicGroup;
    /**
     * id.
     */
    java.lang.String              id                   = null;
    
    private int                   type                 = 0;
    
    private List<SecBasDicGroup>  dicGroupList;
    
    /**
     * 用于返回zTree数据
     */
    private List<Map>             sonTrees             = new ArrayList<Map>();
    
    /**
     * items 删除记录id数组.
     */
    private String[]              items;
    
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
            secBasDicGroup = new SecBasDicGroup();
        } else {
            secBasDicGroup = secBasDicGroupManager.getById(id);
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public Object getModel() {
        return secBasDicGroup;
    }
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
     * 
     * @param manager
     *            manager.
     */
    public void setSecBasDicGroupManager(SecBasDicGroupManager manager) {
        this.secBasDicGroupManager = manager;
    }
    
    public void setSecBasDicItemManager(SecBasDicItemManager secBasDicItemManager) {
        this.secBasDicItemManager = secBasDicItemManager;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public List<SecBasDicGroup> getDicGroupList() {
        return dicGroupList;
    }
    
    public void setDicGroupList(List<SecBasDicGroup> dicGroupList) {
        this.dicGroupList = dicGroupList;
    }
    
    /**
     * @param val
     *            id.
     */
    public void setGroupId(java.lang.String val) {
        this.id = val;
    }
    
    /**
     * @param items
     *            items.
     */
    public void setItems(String[] items) {
        this.items = items;
    }
    
    public List<Map> getSonTrees() {
        return sonTrees;
    }
    
    public void setSonTrees(List<Map> sonTrees) {
        this.sonTrees = sonTrees;
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
     * 显示所有字典组与其字典项
     */
    public String showAllDicGroup() {
        if (type > 0) {
            findAllDicGroupList();
            return GROUP_LIST_JSP;
        } else {
            return ITEM_GROUP_LIST_JSP;
        }
    }
    
    public void findAllDicGroupList() {
        if (dicGroupList == null) {
            dicGroupList = secBasDicGroupManager.findAllDicGroupListByOrder();
        }
    }
    
    /***************************************************************************
     * ajax读取zTree的值，返回json串
     */
    public String zTreeGroupOrder() {
        List<SecBasDicGroup> secBasDicGroupList = secBasDicGroupManager.selectAllGroupListOrder();
        Map tree = new HashMap();
        tree.put("id", "0");
        tree.put("pId", "0");
        tree.put("name", "字典组菜单");
        tree.put("isParent", true);
        tree.put("open", true);
        sonTrees.add(tree);
        for (SecBasDicGroup secBasDicGroup : secBasDicGroupList) {
            Map map = makeTree(secBasDicGroup);
            sonTrees.add(map);
        }
        return SUCCESS;
    }
    
    /*
     * 根据zTree要求的格式构造map名单
     */
    private Map makeTree(SecBasDicGroup secBasDicGroup) {
        Map tree = new HashMap();
        tree.put("id", secBasDicGroup.getGroupId());
        if (secBasDicGroup.getParentId() == null) {
            tree.put("pId", "0");
        } else {
            tree.put("pId", secBasDicGroup.getParentId());
        }
        tree.put("name", secBasDicGroup.getGroupName());
        
        if (secBasDicGroup.getGroupVieworder() != null
            && secBasDicGroup.getGroupVieworder().length() == secBasDicGroup.GROUP_VIEWORDER_LEVEL) // 菜单4位一级
            tree.put("open", true);
        tree.put("groupDescription", secBasDicGroup.getGroupDescription());
        tree.put("groupVieworder", secBasDicGroup.getGroupVieworder());
        return tree;
    }
    
    /**
     * 执行搜索.
     * 
     * @return 搜索页面.
     */
    public String list() {
        PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
        // pageRequest.getFilters().put("key",value); //add custom filter
        Page page = secBasDicGroupManager.findByPageRequest(pageRequest);
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
     * 进入新增下级页面
     * 
     * @return 新增下级分组.
     */
    public String create() {
        String vieworder = secBasDicGroupManager.selectGroupVieworder(this.secBasDicGroup);
        SecBasDicGroup secViewDicGroup = new SecBasDicGroup();
        if (this.secBasDicGroup == null || isNullOrEmptyString(this.secBasDicGroup.getGroupId())) {
            secViewDicGroup.setParentId(null);
        } else {
            secViewDicGroup.setParentId(this.secBasDicGroup.getGroupId());
        }
        secViewDicGroup.setGroupVieworder(vieworder);
        secViewDicGroup.setGroupFlag(SecBasDicGroup.GROUP_FLAG_VISIBLE);
        this.secBasDicGroup = secViewDicGroup;
        return CREATE_JSP;
    }
    
    /**
     * 保存新增对象.
     * 
     * @return 重定向到列表页面.
     */
    public String save() {
        secBasDicGroupManager.save(secBasDicGroup);
        return LIST_ACTION;
    }
    
    /**
     * 进入更新页面.
     * 
     * @return 更新页面.
     */
    public String edit() {
        System.out.println(this.secBasDicGroup.getGroupId());
        return EDIT_JSP;
    }
    
    /**
     * 保存更新对象.
     * 
     * @return 重定向到列表页面.
     */
    public String update() {
        secBasDicGroupManager.update(this.secBasDicGroup);
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
            java.lang.String id = new java.lang.String((String) params.get("groupId"));
            secBasDicGroupManager.removeById(id);
        }
        return LIST_ACTION;
    }
    
    /**
     * 删除对象（并非真正的删除，只是将显示状态为变为0）,删除分组的同时，删除分组中的字典项、删除子分组和子分组对应的字典项
     * 
     * @return 重定向到列表页面.
     */
    public String deleteById() {
        if (StringUtils.isNotBlank(id)) {
            // 修改该字典组的显示状态
            this.secBasDicGroup = secBasDicGroupManager.getById(id);
            secBasDicGroup.setGroupFlag(secBasDicGroup.GROUP_FLAG_INVISIBLE);
            secBasDicGroupManager.update(secBasDicGroup);
            // 查询该字典组内所有的字典项，并修改其显示状态
            List<SecBasDicItem> itemList = secBasDicItemManager.findAllBy("groupId", id);
            if (!isNullOrEmptyString(itemList) && itemList.size() > 0) {
                for (SecBasDicItem dicItem : itemList) {
                    dicItem.setItemFlag(dicItem.ITEM_FLAG_INVISIBLE);
                    secBasDicItemManager.update(dicItem);
                }
            }
            
            // 查询该字典组内所有子字典组，并修改其显示状态
            List<SecBasDicGroup> sonGroupList = secBasDicGroupManager.findAllBy("parentId", id);
            if (!isNullOrEmptyString(sonGroupList) && sonGroupList.size() > 0) {
                for (SecBasDicGroup dicGroup : sonGroupList) {
                    dicGroup.setGroupFlag(dicGroup.GROUP_FLAG_INVISIBLE);
                    secBasDicGroupManager.update(dicGroup);
                    
                    // 查询该字典组内所有子字典组内的字典项，并修改其显示状态
                    List<SecBasDicItem> sonItemList = secBasDicItemManager.findAllBy("groupId", dicGroup.getGroupId());
                    if (!isNullOrEmptyString(sonItemList) && sonItemList.size() > 0) {
                        for (SecBasDicItem sonDicItem : sonItemList) {
                            sonDicItem.setItemFlag(sonDicItem.ITEM_FLAG_INVISIBLE);
                            secBasDicItemManager.update(sonDicItem);
                        }
                    }
                }
            }
            
        }
        return LIST_ACTION;
    }
    
    @Override
    public String getEctableId() {
        return "SecBasDicGroup_list";
    }
}
