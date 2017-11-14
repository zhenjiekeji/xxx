/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.uk.sec.framework.base.BaseStruts2Action;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicGroup;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicItem;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeMenu;
import com.uk.sec.privilege.framework.privilege.service.SecBasDicItemManager;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeMenuManager;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeMenuOperManager;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class SecPrivilegeMenuAction extends BaseStruts2Action implements Preparable, ModelDriven {
    /**
     * 默认多列排序,example: username desc,createTime asc.
     */
    protected static final String       DEFAULT_SORT_COLUMNS       = null;
    /*
     * 跳转地址.---------------START---------------
     */
    /**
     * 列表页面.
     */
    protected static final String       LIST_JSP                   = "/framework/privilege/SecPrivilegeMenu/list.jsp";
    /**
     * 编辑页面.
     */
    protected static final String       EDIT_JSP                   = "/framework/privilege/SecPrivilegeMenu/edit.jsp";
    /**
     * 添加下级菜单页面.
     */
    protected static final String       ADD_LOWER_LEVEL_MENU_JSP   = "/framework/privilege/SecPrivilegeMenu/addLowerLevelMenu.jsp";
    /**
     * 菜单关联操作页面.
     */
    protected static final String       MENU_RELATE_OPERATIONS_JSP = "/framework/privilege/SecPrivilegeMenu/menuRelateOperations.jsp";
    /*
     * 跳转地址.---------------E N D---------------
     */

    /*
     * 重定向地址以!开头.---------------START---------------
     */
    /**
     * LIST_ACTION 跳转到列表页面.
     */
    protected static final String       LIST_ACTION                = "!/framework/privilege/SecPrivilegeMenu/list.do"
                                                                     + NOTIFY_STATE;
    /*
     * 重定向地址以!开头.---------------E N D---------------
     */

    /*
     * 内部成员定义.---------------START---------------
     */
    /**
     * manager.
     */
    private SecPrivilegeMenuManager     secPrivilegeMenuManager;
    private SecPrivilegeMenuOperManager secPrivilegeMenuOperManager;
    private SecBasDicItemManager        secBasDicItemManager;
    /**
     * model.
     */
    private SecPrivilegeMenu            secPrivilegeMenu;
    
    private List<SecBasDicItem>         allOperationList;                                                                             // 字典项表中所有的操作列表
    private List<SecBasDicItem>         menuOperationList;                                                                            // 菜单操作关联表中菜单关联的操作列表
                                                                                                                                       
    /**
     * id.
     */
    java.lang.String                    id                         = null;
    
    private final List<Map>             sonTrees                   = new ArrayList<Map>();
    /**
     * items 删除记录id数组.
     */
    private String[]                    items;
    private Long[]                      operationId;
    private String                      ztreeIdAndPid;
    
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
            secPrivilegeMenu = new SecPrivilegeMenu();
        } else {
            secPrivilegeMenu = secPrivilegeMenuManager.getById(id);
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public Object getModel() {
        return secPrivilegeMenu;
    }
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
     * 
     * @param manager
     *            manager.
     */
    public void setSecPrivilegeMenuManager(SecPrivilegeMenuManager manager) {
        this.secPrivilegeMenuManager = manager;
    }
    
    public void setSecPrivilegeMenuOperManager(SecPrivilegeMenuOperManager secPrivilegeMenuOperManager) {
        this.secPrivilegeMenuOperManager = secPrivilegeMenuOperManager;
    }
    
    public void setSecBasDicItemManager(SecBasDicItemManager secBasDicItemManager) {
        this.secBasDicItemManager = secBasDicItemManager;
    }
    
    public List<SecBasDicItem> getAllOperationList() {
        return allOperationList;
    }
    
    public List<SecBasDicItem> getMenuOperationList() {
        return menuOperationList;
    }
    
    /**
     * @param val
     *            id.
     */
    public void setMenuId(java.lang.String val) {
        this.id = val;
    }
    
    public List<Map> getSonTrees() {
        return sonTrees;
    }
    
    /**
     * @param items
     *            items.
     */
    public void setItems(String[] items) {
        this.items = items;
    }
    
    public void setOperationId(Long[] operationId) {
        this.operationId = operationId;
    }
    
    public void setZtreeIdAndPid(String ztreeIdAndPid) {
        this.ztreeIdAndPid = ztreeIdAndPid;
    }
    
    /**
     * 执行搜索.
     * 
     * @return 搜索页面.
     */
    public String list() {
        return LIST_JSP;
    }
    
    /**
     * 查询zTree树结构List<Map>，并以json形式返回 根据菜单的显示顺序查询菜单表中的所有可见的菜单列表
     */
    public String zTreeMenuOrder() {
        List<SecPrivilegeMenu> secPrivilegeMenuList = secPrivilegeMenuManager.selectAllMenuListOrder();
        Map tree = new HashMap();
        tree.put("id", "0");
        tree.put("pId", "0");
        tree.put("name", "树形菜单");
        tree.put("isParent", true);
        tree.put("open", true);
        sonTrees.add(tree);
        for (SecPrivilegeMenu secPrivilegeMenu : secPrivilegeMenuList) {
            Map map = makeTree(secPrivilegeMenu);
            sonTrees.add(map);
        }
        return SUCCESS;
    }
    
    /*
     * 根据zTree要求的格式构造map名单
     */
    private Map makeTree(SecPrivilegeMenu secPrivilegeMenu) {
        Map tree = new HashMap();
        tree.put("id", secPrivilegeMenu.getMenuId());
        if (secPrivilegeMenu.getParentId() == null) {
            tree.put("pId", "0");
        } else {
            tree.put("pId", secPrivilegeMenu.getParentId());
        }
        tree.put("name", secPrivilegeMenu.getMenuTitle());
        if (secPrivilegeMenu.getMenuIsleaf() == 1) {
            tree.put("isParent", false);
        } else {
            tree.put("isParent", true);
        }
        if (secPrivilegeMenu.getMenuVieworder() != null
            && secPrivilegeMenu.getMenuVieworder().length() == SecPrivilegeMenu.MENU_VIEWORDER_LEVEL) // 菜单4位一级
            tree.put("open", true);
        tree.put("menuDescription", secPrivilegeMenu.getMenuDescription());
        tree.put("menuUrl", secPrivilegeMenu.getMenuUrl());
        tree.put("menuVieworder", secPrivilegeMenu.getMenuVieworder());
        return tree;
    }
    
    /**
     * 重新更新菜单树的pId以及vieworder
     */
    public String submitZtreeMenu() {
        secPrivilegeMenuManager.submitZtreeMenuVieworder(this.ztreeIdAndPid);
        return LIST_ACTION;
    }
    
    /**
     * 菜单关联操作.
     * 
     * @return 菜单关联操作页面.
     */
    public String menuRelateOperations() {
        allOperationList = secBasDicItemManager.selectDicItemListByGroupId(SecBasDicGroup.DicGroupEnum.MENU_OPERATION_ENUM.getGroupId());
        menuOperationList = secPrivilegeMenuOperManager.selectOperationByMenuId(id);
        return MENU_RELATE_OPERATIONS_JSP;
    }
    
    public String saveMenuRelateOperations() {
        secPrivilegeMenuOperManager.saveMenuRelateOperations(operationId, id);
        return LIST_ACTION;
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
     * 保存新增对象.
     * 
     * @return 重定向到列表页面.
     */
    public String save() {
        /*if (secPrivilegeMenu.getMenuIsleaf() == SecPrivilegeMenu.MENU_NOT_LEAF) {
            secPrivilegeMenu.setMenuUrl(null);
        }*/
        secPrivilegeMenu.setMenuIsleaf(SecPrivilegeMenu.MENU_NOT_LEAF);
        secPrivilegeMenuManager.save(secPrivilegeMenu);
        return LIST_ACTION;
    }
    
    /**
     * 保存更新对象.
     * 
     * @return 重定向到列表页面.
     */
    public String update() {
        /*if (secPrivilegeMenu.getMenuIsleaf() == SecPrivilegeMenu.MENU_NOT_LEAF) {
            secPrivilegeMenu.setMenuUrl(null);
        }*/
        secPrivilegeMenuManager.update(this.secPrivilegeMenu);
        return LIST_ACTION;
    }
    
    /**
     * 添加下级菜单.
     * 
     * @return 添加下级菜单页面.
     */
    public String addLowerLevelMenu() {
        String vieworder = secPrivilegeMenuManager.selectMenuVieworder(this.secPrivilegeMenu);
        SecPrivilegeMenu secViewPrivilegeMenu = new SecPrivilegeMenu();
        if (this.secPrivilegeMenu == null || isNullOrEmptyString(this.secPrivilegeMenu.getMenuId())) {
            secViewPrivilegeMenu.setParentId(null);
        } else {
            secViewPrivilegeMenu.setParentId(this.secPrivilegeMenu.getMenuId());
        }
        secViewPrivilegeMenu.setMenuVieworder(vieworder);
        secViewPrivilegeMenu.setMenuFlag(SecPrivilegeMenu.MENU_FLAG_VISIBLE);
        this.secPrivilegeMenu = secViewPrivilegeMenu;
        return ADD_LOWER_LEVEL_MENU_JSP;
    }
    
    /**
     * 删除对象.
     * 
     * @return 重定向到列表页面.
     */
    public String deleteById() {
        if (StringUtils.isNotBlank(id)) {
            secPrivilegeMenuManager.deleteByMenuId(this.secPrivilegeMenu);
        }
        return LIST_ACTION;
    }
    
    @Override
    public String getEctableId() {
        return "SecPrivilegeMenu_list";
    }
}
