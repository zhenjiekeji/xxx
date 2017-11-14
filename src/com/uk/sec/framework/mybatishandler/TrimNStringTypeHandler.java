/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.mybatishandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.NStringTypeHandler;

import com.uk.sec.framework.log.LogFactory;


/**
 * @author xzw.
 * @since 1.0
 * @version 1.0
 */
public class TrimNStringTypeHandler extends NStringTypeHandler {
    
    /**
     * {@inheritDoc}
     * 
     * @see org.apache.ibatis.type.NStringTypeHandler#setNonNullParameter(java.sql.PreparedStatement,
     *      int, java.lang.String, org.apache.ibatis.type.JdbcType)
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException {
        LogFactory.LOGGER_FRAMEWORK.info("Original parameter is " + parameter);
        parameter = Utils.trim(parameter);
        LogFactory.LOGGER_FRAMEWORK.info("Trimmed parameter is " + parameter);
        ps.setString(i, parameter);
    }
    
}