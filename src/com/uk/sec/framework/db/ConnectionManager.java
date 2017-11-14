package com.uk.sec.framework.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 数据库连接管理工具 2.0版本改为了数据库连接池管理连接，可以直接获取DataSource
 * 
 * @version 2.0
 */
public class ConnectionManager {
    
    private final BasicDataSource    dataSource;
    
    private static ConnectionManager INSTANCE = new ConnectionManager();
    
    public static ConnectionManager getInstance() {
        return INSTANCE;
    }
    
    private ConnectionManager() {
        DatabaseSettings settings = DatabaseSettings.getInstance();
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(settings.getJdbcDriver());
        dataSource.setUrl(settings.getJdbcUrl());
        dataSource.setUsername(settings.getJdbcUsername());
        dataSource.setPassword(settings.getJdbcPassword());
        dataSource.setInitialSize(settings.getInitPoolSize());
        dataSource.setMaxActive(settings.getMaxPoolSize());
        dataSource.setPoolPreparedStatements(settings.isPoolPreparedStatements());
        dataSource.setMaxOpenPreparedStatements(settings.getMaxOpenPreparedStatements());
    }
    
    /**
     * 获取一个数据库连接
     * 
     * @return 数据库连接
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    
    /**
     * 获取DataSource
     * 
     * @return
     * @throws SQLException
     */
    public DataSource getDataSource() throws SQLException {
        return dataSource;
    }
    
    public void close() throws SQLException {
        dataSource.close();
    }
}
