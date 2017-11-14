package com.uk.sec.framework.db;

import com.uk.sec.framework.util.SettingManager;

/**
 * 数据库配置 1.5版主要是针对ConnectionManager增加了连接池功能后新增加的配置项。 使用数据库应该包含数据库相关的配置，如下面的例子：
 * jdbc.driver=com.mysql.jdbc.Driver jdbc.url=jdbc:mysql://127.0.0.1:3306/test
 * jdbc.username=root jdbc.password= jdbc.initPoolSize=5 jdbc.maxPoolSize=5
 * jdbc.poolPreparedStatements=false jdbc.maxOpenPreparedStatements=0
 * 前四项为数据库的驱动，JDBC URL，用户名及密码，这四项为必须配置的内容。 后面四项为数据库连接池的配置项，为可选项，可以不进行配置，分别为初始化
 * 连接池大小，连接池最大连接数，是否存储PreparedStatement，以及其存储的 最大限额，0为不限制大小。
 * 
 * @version 1.5
 */
public class DatabaseSettings {
    
    private static DatabaseSettings INSTANCE = new DatabaseSettings();
    private static SettingManager   settings = SettingManager.getInstance();
    
    public static DatabaseSettings getInstance() {
        return INSTANCE;
    }
    
    private DatabaseSettings() {
    }
    
    public String getJdbcDriver() {
        return settings.getConfig().getString("jdbc.driver");
    }
    
    public String getJdbcUrl() {
        return settings.getConfig().getString("jdbc.url");
    }
    
    public String getJdbcUsername() {
        return settings.getConfig().getString("jdbc.username");
    }
    
    public String getJdbcPassword() {
        return settings.getConfig().getString("jdbc.password");
    }
    
    public int getInitPoolSize() {
        return settings.getConfig().getInt("jdbc.initPoolSize", 5);
    }
    
    public int getMaxPoolSize() {
        return settings.getConfig().getInt("jdbc.maxPoolSize", 5);
    }
    
    public boolean isPoolPreparedStatements() {
        return settings.getConfig().getBoolean("jdbc.poolPreparedStatements", false);
    }
    
    public int getMaxOpenPreparedStatements() {
        return settings.getConfig().getInt("jdbc.maxOpenPreparedStatements", 0);
    }
}
