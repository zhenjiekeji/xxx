/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.system.dao;

import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.uk.sec.framework.base.BaseIbatis3Dao;
import com.uk.sec.framework.system.model.SecSysRulevalue;

/**
 * @author
 * @since 1.0
 * @version 1.0
 */
@Component
public class SecSysRulevalueDao extends BaseIbatis3Dao<SecSysRulevalue,java.lang.String>{
    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#getEntityClass()
     */
    public Class getEntityClass() {
        return SecSysRulevalue.class;
    }
    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#saveOrUpdate(java.lang.Object)
     */
    public void saveOrUpdate(SecSysRulevalue entity) {
        if(entity.getId() == null)
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
        return pageQuery("SecSysRulevalue.pageSelect",pageRequest);
    }


}
