/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.base.EntityDao;
import com.uk.sec.privilege.framework.privilege.dao.SecPrivilegeMenuDao;
import com.uk.sec.privilege.framework.privilege.dao.SecPrivilegeMenuOperDao;
import com.uk.sec.privilege.framework.privilege.dao.SecPrivilegeRoleMenuOperDao;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeMenu;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

@Component
@Transactional
public class SecPrivilegeMenuManager extends BaseManager<SecPrivilegeMenu, java.lang.String> {
    /**
     * historyDao
     */
    private SecPrivilegeMenuDao         secPrivilegeMenuDao;
    
    private SecPrivilegeMenuOperDao     secPrivilegeMenuOperDao;
    
    private SecPrivilegeRoleMenuOperDao secPrivilegeRoleMenuOperDao;
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     * 
     * @param dao
     *            dao.
     */
    public void setSecPrivilegeMenuDao(SecPrivilegeMenuDao dao) {
        this.secPrivilegeMenuDao = dao;
    }
    
    public void setSecPrivilegeMenuOperDao(SecPrivilegeMenuOperDao secPrivilegeMenuOperDao) {
        this.secPrivilegeMenuOperDao = secPrivilegeMenuOperDao;
    }
    
    public void setSecPrivilegeRoleMenuOperDao(SecPrivilegeRoleMenuOperDao secPrivilegeRoleMenuOperDao) {
        this.secPrivilegeRoleMenuOperDao = secPrivilegeRoleMenuOperDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#getEntityDao()
     */
    @Override
    public EntityDao getEntityDao() {
        return this.secPrivilegeMenuDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    @Override
    @Transactional(readOnly = true)
    public Page findByPageRequest(PageRequest pr) {
        return secPrivilegeMenuDao.findByPageRequest(pr);
    }
    
    public List<SecPrivilegeMenu> selectAllMenuListOrder() {
        return secPrivilegeMenuDao.selectAllMenuListOrder();
    }

    
    /**
     * 查询zTree树结构List<Map>，并以json形式返回 根据菜单的显示顺序查询菜单表中的所有可见的菜单列表
     */
    public List<Map> getRoleRelateMenuZtreeMap(Map<String, Object> selectedItemMap) {
        List<SecPrivilegeMenu> secPrivilegeMenuList = secPrivilegeMenuDao.selectAllMenuListOrder();
        List<Map> menuMap = new ArrayList<Map>();
        for (SecPrivilegeMenu secPrivilegeMenu : secPrivilegeMenuList) {
            Map map = makeTree(secPrivilegeMenu,selectedItemMap);
            menuMap.add(map);
        }
        return menuMap;
    }
    
    /*
     * 根据zTree要求的格式构造map名单
     */
    private Map makeTree(SecPrivilegeMenu secPrivilegeMenu,Map<String, Object> selectedItemMap) {
        Map tree = new HashMap();
        tree.put("id", secPrivilegeMenu.getMenuId());
        if (secPrivilegeMenu.getParentId() == null) {
            tree.put("pId", "0");
        } else {
            tree.put("pId", secPrivilegeMenu.getParentId());
        }
        tree.put("name", secPrivilegeMenu.getMenuTitle());
        if (selectedItemMap != null && selectedItemMap.containsKey(String.valueOf(secPrivilegeMenu.getMenuId()))) {
            tree.put("checked", true);
        } else {
            tree.put("checked", false);
        }
        return tree;
    }    
    
    
    /**
     * @description 根据用户登陆ID来查询其所在权限内所有菜单
     * @param loginId
     * @return List<SecPrivilegeMenu> 菜单List
     */
    public List<SecPrivilegeMenu> findAllMenuByLoginId(String loginId) {
        return secPrivilegeMenuDao.findAllMenuByLoginId(loginId);
    }
    
    /**
     * @description 根据用户登陆ID和父菜单来查询其所在权限内所有二级菜单
     * @param loginId,parentId
     * @return List<SecPrivilegeMenu> 菜单List
     */
    public List<SecPrivilegeMenu> findMenuByLoginIdAndParentId(String loginId, String parentId) {
        return secPrivilegeMenuDao.findMenuByLoginIdAndParentId(loginId, parentId);
    }
    
    /**
     * 返回当前选中菜单下级菜单的最大vieworder+1.
     * 
     * @return String.
     */
    public String selectMenuVieworder(SecPrivilegeMenu secPrivilegeMenu) {
        String vieworder = secPrivilegeMenuDao.selectMenuVieworderMax(secPrivilegeMenu);
        int viewOrderLength = vieworder == null ? SecPrivilegeMenu.MENU_VIEWORDER_LEVEL : vieworder.length();
        String revertVieworder = vieworder == null ? "1" : String.valueOf(Long.valueOf(vieworder) + 1);
        int circleNumber = viewOrderLength - revertVieworder.length();
        StringBuffer bf = new StringBuffer();
        if (secPrivilegeMenu != null && vieworder == null) {
            bf.append(secPrivilegeMenu.getMenuVieworder());
        }
        for (int i = 1; i <= circleNumber; i++) {
            bf.append('0');
        }
        bf.append(revertVieworder);
        return bf.toString();
    }
    
    public void deleteByMenuId(SecPrivilegeMenu secPrivilegeMenu) {
        // 删除菜单、操作表中该菜单关联的操作
        secPrivilegeMenuOperDao.deleteByMenuId(secPrivilegeMenu.getMenuId());
        // 删除角色、菜单、操作表中该菜单关联的记录
        secPrivilegeRoleMenuOperDao.deleteByMenuId(secPrivilegeMenu.getMenuId());
        // 删除该菜单
        secPrivilegeMenuDao.deleteById(secPrivilegeMenu.getMenuId());
        // 调整该菜单的同级菜单vieworder顺序（只调整同级菜单中vieworder>该菜单的顺序）
        secPrivilegeMenuDao.updateVieworderBySameLevel(secPrivilegeMenu);
    }
    
    /**
     * 重新更新菜单树的pId以及vieworder
     */
    public void submitZtreeMenuVieworder(String ztreeIdAndPid) {
        String[] ztreeIdAndPidArray = ztreeIdAndPid.split(",");
        Map<String, String[]> idAndPidVieworder = new HashMap<String, String[]>(); // key:id
        // value:String[0]:pid,String[1]:vieworder
        Map<String, List<String>> pidAndIdList = new HashMap<String, List<String>>(); // key:pid
        // value:list<id>
        for (String element : ztreeIdAndPidArray) {
            int index = element.indexOf("@");
            String id = element.substring(0, index);
            String pId = element.substring(index + 1);
            String[] pIdAndVieworderArray = new String[2];
            pIdAndVieworderArray[0] = pId;
            idAndPidVieworder.put(id, pIdAndVieworderArray);
            if (pidAndIdList.get(pId) == null) {
                List<String> idList = new ArrayList<String>();
                pidAndIdList.put(pId, idList);
            }
            pidAndIdList.get(pId).add(id);
        }
        List<String> oneLevelMenuList = pidAndIdList.get("0"); // 前台默认传递的无父节点菜单的parentId为0
        for (int i = 0; i < oneLevelMenuList.size(); i++) {
            int circleNumber = SecPrivilegeMenu.MENU_VIEWORDER_LEVEL - String.valueOf(Long.valueOf(i) + 1).length();
            StringBuffer bf = new StringBuffer();
            for (int j = 1; j <= circleNumber; j++) {
                bf.append('0');
            }
            bf.append(String.valueOf(Long.valueOf(i) + 1));
            idAndPidVieworder.get(oneLevelMenuList.get(i))[1] = bf.toString();
        }
        for (String oneLevelMenu : oneLevelMenuList) {
            setMenuViewOrder(oneLevelMenu, idAndPidVieworder, pidAndIdList);
        }
        for (String menuId : idAndPidVieworder.keySet()) {
            SecPrivilegeMenu secPrivilegeMenu = new SecPrivilegeMenu();
            secPrivilegeMenu.setMenuId(menuId);
            if ("0".equals(idAndPidVieworder.get(menuId)[0])) {
                secPrivilegeMenu.setParentId(null);
            } else {
                secPrivilegeMenu.setParentId(idAndPidVieworder.get(menuId)[0]);
            }
            secPrivilegeMenu.setMenuVieworder(idAndPidVieworder.get(menuId)[1]);
            secPrivilegeMenuDao.updatePidAndVieworder(secPrivilegeMenu);
        }
    }
    
    /**
     * 递归相应的菜单vieworder重新赋值
     */
    public void setMenuViewOrder(String pId, Map idAndPidVieworder, Map pidAndIdList) {
        if (pidAndIdList.get(pId) == null)
            return;
        List<String> idList = (List<String>) pidAndIdList.get(pId);
        for (int i = 0; i < idList.size(); i++) {
            String[] pIdVieworderArray = (String[]) idAndPidVieworder.get(pId);
            StringBuffer bf = new StringBuffer(pIdVieworderArray[1]);
            int circleNumber = SecPrivilegeMenu.MENU_VIEWORDER_LEVEL - String.valueOf(Long.valueOf(i) + 1).length();
            for (int j = 1; j <= circleNumber; j++) {
                bf.append('0');
            }
            bf.append(String.valueOf(Long.valueOf(i) + 1));
            String[] idAndPidVieworderArray = (String[]) idAndPidVieworder.get(idList.get(i));
            idAndPidVieworderArray[1] = bf.toString();
            setMenuViewOrder(idList.get(i), idAndPidVieworder, pidAndIdList);
        }
    }
    
    // public SecPrivilegeMenu findFirstUrlByOrder(String viewOrder) {
    // return secPrivilegeMenuDao.findFirstUrlByOrder(viewOrder);
    // }
}
