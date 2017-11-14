/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.uk.sec.framework.base.BaseIbatis3Dao;
import com.uk.sec.framework.security.action.UserView;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeMenu;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @since 1.0
 * @version 1.0
 */
@Component
public class SecPrivilegeMenuDao extends BaseIbatis3Dao<SecPrivilegeMenu, java.lang.String> {
    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#getEntityClass()
     */
    @Override
    public Class getEntityClass() {
        return SecPrivilegeMenu.class;
    }

    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(SecPrivilegeMenu entity) {
        if (entity.getMenuId() == null)
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
        return pageQuery("SecPrivilegeMenu.pageSelect", pageRequest);
    }

    /**
     * @description 根据用户登陆ID来查询其所在权限内所有菜单
     * @param loginId
     * @return List<SecPrivilegeMenu> 菜单List
     */
    public List<SecPrivilegeMenu> findAllMenuByLoginId(String loginId) {
        return this.getSqlSession().selectList("SecPrivilegeMenu.findAllMenuByLoginId", loginId);
    }

    public List<SecPrivilegeMenu> findMenuByLoginIdAndParentId(String loginId, String parentId) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("loginId", loginId);
        param.put("parentId", parentId);
        return this.getSqlSession().selectList("SecPrivilegeMenu.findMenuByLoginIdAndParentId", param);
    }
    
    public List<SecPrivilegeMenu> selectAllMenuListOrder() {
        return this.getSqlSession().selectList("SecPrivilegeMenu.selectAllMenuListOrder");
    }

    public String selectMenuVieworderMax(SecPrivilegeMenu secPrivilegeMenu) {
        return (String) this.getSqlSession().selectOne("SecPrivilegeMenu.selectMenuVieworderMax", secPrivilegeMenu);
    }

    public void updateVieworderBySameLevel(SecPrivilegeMenu secPrivilegeMenu) {
        this.getSqlSession().update("SecPrivilegeMenu.updateVieworderBySameLevel", secPrivilegeMenu);
    }

    public void updatePidAndVieworder(SecPrivilegeMenu secPrivilegeMenu) {
        this.getSqlSession().update("SecPrivilegeMenu.updatePidAndVieworder", secPrivilegeMenu);
    }

    /**
     * @description 根据用户登陆ID和菜单url来查询其所在权限内所有菜单
     * @param url
     * @return List<SecPrivilegeMenu> 菜单List
     */
    public SecPrivilegeMenu selectMenuByLoginIdAndUrl(String menuUrl) {
        Map<String, String> map = new HashMap<String, String>();
        UserView<String> userView = (UserView<String>) ServletActionContext.getRequest()
                                                                           .getSession()
                                                                           .getAttribute(UserView.SESSION_USER_VIEW);
        map.put("loginId", userView.getLoginId());
        map.put("menuUrl", menuUrl);
        List<SecPrivilegeMenu> secPrivilegeMenuList = this.getSqlSession().selectList("SecPrivilegeMenu.selectMenuByLoginIdAndUrl",
                                                                     map);
        if (secPrivilegeMenuList == null || secPrivilegeMenuList.isEmpty()) {
            return null;
        } else {
            return secPrivilegeMenuList.get(0);
        }
    }

}
