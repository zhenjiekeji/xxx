/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.security.service;

import java.io.Serializable;

import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.security.model.UserInfo;


/**
 * @author xzw.
 * @since 1.0
 * @version 1.0
 */
public abstract class SecUserManager<E, PK extends Serializable> extends BaseManager<E, PK> {
    public abstract UserInfo<PK> getSecUserInfoByUsername(String userName);
}
