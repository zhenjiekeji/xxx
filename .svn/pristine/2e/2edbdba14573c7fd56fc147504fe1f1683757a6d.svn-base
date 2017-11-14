/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uk.sec.framework.base.BaseIbatis3Dao;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicGroup;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @since 1.0
 * @version 1.0
 */
@Component
public class SecBasDicGroupDao extends BaseIbatis3Dao<SecBasDicGroup, java.lang.String> {
    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#getEntityClass()
     */

    @Override
    public Class getEntityClass() {
        return SecBasDicGroup.class;
    }

    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(SecBasDicGroup entity) {
        if (entity.getGroupId() == null)
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
        return pageQuery("SecBasDicGroup.pageSelect", pageRequest);
    }

    public Long dicGroupCount() {
        return (Long) this.getSqlSession().selectOne(this.getCountQuery());
    }

    public List<SecBasDicGroup> querySonTreeByFatherId(String fatherId) {
    	SecBasDicGroup secBasDicGroup = new SecBasDicGroup();
    	secBasDicGroup.setParentId(fatherId);
        return this.getSqlSession().selectList("SecBasDicGroup.querySonTreeByFatherId", secBasDicGroup);
    }

    public List<SecBasDicGroup> selectAllGroupListOrder() {
        return this.getSqlSession().selectList("SecBasDicGroup.selectAllGroupListOrder");
    }

    public String selectGroupVieworderMax(SecBasDicGroup secBasDicGroup) {
        return (String) this.getSqlSession().selectOne("SecBasDicGroup.selectGroupVieworderMax", secBasDicGroup);
    }

}
