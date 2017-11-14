/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.uk.sec.framework.base.BaseIbatis3Dao;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicGroup;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicItem;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @since 1.0
 * @version 1.0
 */
@Component
public class SecBasDicItemDao extends BaseIbatis3Dao<SecBasDicItem, java.lang.String> {
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseIbatis3Dao#getEntityClass()
     */
    @Override
    public Class getEntityClass() {
        return SecBasDicItem.class;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseIbatis3Dao#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(SecBasDicItem entity) {
        if (entity.getDicId() == null)
            save(entity);
        else
            update(entity);
    }
    
    /**
     * 分页查询.
     * 
     * @param pageRequest
     *            查询参数.
     * @return page.
     */
    public Page findByPageRequest(PageRequest pageRequest) {
        return pageQuery("SecBasDicItem.pageSelect", pageRequest);
    }
    
    /**
     * 查询相应的字典组下所有的字典项.
     */
    public List<SecBasDicItem> selectDicItemListByGroupId(String groupId) {
        return this.getSqlSession().selectList("SecBasDicItem.selectDicItemListByGroupId", groupId);
    }

    /**
     * 根据groupId,orderColumn,查询出List<SecBasDicItem>.
     */
    public List<SecBasDicItem> selectDicItemByGroupIdAndOrder(Map map) {
        return this.getSqlSession().selectList("SecBasDicItem.selectDicItemByGroupIdAndOrder", map);
    }    
    
    /**
     * 具体菜单对应的所有的操作列表信息.
     */
    public List<SecBasDicItem> selectOperationByMenuId(String menuId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("menuId", menuId);
        map.put("groupId", SecBasDicGroup.DicGroupEnum.MENU_OPERATION_ENUM.getGroupId());
        return this.getSqlSession().selectList("SecBasDicItem.selectOperationByMenuId", map);
    }
    
    /**
     * 具体角色菜单对应的所有的操作列表信息.
     */
    public List<SecBasDicItem> selectOperationByRoleIdMenuId(String roleId, String menuId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("roleId", roleId);
        map.put("menuId", menuId);
        map.put("groupId", SecBasDicGroup.DicGroupEnum.MENU_OPERATION_ENUM.getGroupId());
        return this.getSqlSession().selectList("SecBasDicItem.selectOperationByRoleIdMenuId", map);
    }
    
    /**
     * 具体帐号对应角色在相应的菜单下所有的操作列表信息.
     */
    public List<SecBasDicItem> selectOperationByLoginIdMenuId(String loginId, String menuId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginId", loginId);
        map.put("menuId", menuId);
        map.put("groupId", SecBasDicGroup.DicGroupEnum.MENU_OPERATION_ENUM.getGroupId());
        return this.getSqlSession().selectList("SecBasDicItem.selectOperationByLoginIdMenuId", map);
    }
    
    /**
     * 查询字典项中最大的排序id.
     */
    public Long findMaxItemOrder(String groupId) {
        return (Long) this.getSqlSession().selectOne("SecBasDicItem.findMaxItemOrder", groupId);
    }
    
    /**
     * 查询字典项中最小的排序id.
     */
    public Long findMinItemOrder(String groupId) {
        return (Long) this.getSqlSession().selectOne("SecBasDicItem.findMinItemOrder", groupId);
    }
    
    /**
     * 查询字典项中最大的ItemId.
     */
    public Long findMaxItemId(String groupId) {
        return (Long) this.getSqlSession().selectOne("SecBasDicItem.findMaxItemId", groupId);
    }
    
    /**
     * 下移字典项
     * 
     * @param dicId
     * @param groupId
     */
    public void orderDown(String dicId, String groupId) {
        SecBasDicItem secBasDicItem = new SecBasDicItem();
        secBasDicItem.setDicId(dicId);
        secBasDicItem.setGroupId(groupId);
        this.getSqlSession().selectOne("SecBasDicItem.orderDown", secBasDicItem);
    }
    
    /**
     * 上移字典项
     * 
     * @param dicId
     * @param groupId
     */
    public void orderUp(String dicId, String groupId) {
        SecBasDicItem secBasDicItem = new SecBasDicItem();
        secBasDicItem.setDicId(dicId);
        secBasDicItem.setGroupId(groupId);
        this.getSqlSession().selectOne("SecBasDicItem.orderUp", secBasDicItem);
    }
    
}
