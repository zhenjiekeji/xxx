package com.uk.sec.framework.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * 执行SQL的工具类 2.0 全面将API更改为Apache Common DbUtils的API
 * 
 * @version 2.0
 */
public class SqlExecutor {
    
    private final Connection  connection;
    private final QueryRunner runner;
    
    SqlExecutor() throws SQLException {
        connection = ConnectionManager.getInstance().getConnection();
        runner = new QueryRunner();
    }
    
    SqlExecutor(Connection conn) {
        connection = conn;
        runner = new QueryRunner();
    }
    
    /**
     * 打开一个事务
     * 
     * @throws SQLException
     */
    public void openTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }
    
    // TODO 考虑是否要保留这个方法
    /**
     * 获取本SQLExecutor的数据库连接
     * 
     * @return
     */
    public Connection getConnection() {
        return connection;
    }
    
    /**
     * 验证数据库连接是否关闭
     * 
     * @return
     * @throws SQLException
     */
    public boolean isClosed() throws SQLException {
        return connection.isClosed();
    }
    
    /**
     * 关闭事务
     * 
     * @throws SQLException
     */
    public void closeTransaction() throws SQLException {
        // 在关闭事务之前先把事务提交一次
        connection.commit();
        connection.setAutoCommit(true);
    }
    
    /**
     * 提交事务
     * 
     * @throws SQLException
     */
    public void commit() throws SQLException {
        connection.commit();
    }
    
    /**
     * 回滚
     * 
     * @throws SQLException
     */
    public void rollbakc() throws SQLException {
        connection.rollback();
    }
    
    /**
     * 关闭SQLExecutor，将关闭数据库连接
     * 
     * @throws SQLException
     */
    public void close() throws SQLException {
        connection.close();
    }
    
    /**
     * 预编译执行更新，插入等操作
     * 
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public int update(String sql, Object... params) throws SQLException {
        return runner.update(connection, sql, params);
    }
    
    /**
     * 预编译执行查询操作
     * 
     * @param sql
     *            SQLmin
     * @param params
     * @return
     * @throws SQLException
     */
    public List<Map<String, Object>> select(String sql, Object... params) throws SQLException {
        return runner.query(connection, sql, SqlUtils.MAP_LIST_HANDLER, params);
    }
    
    /**
     * 预编译执行查询操作，查询结果只返回第一个结果
     * 
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public Map<String, Object> selectSingle(String sql, Object... params) throws SQLException {
        return runner.query(connection, sql, SqlUtils.MAP_HANDLER, params);
    }
    
    /**
     * 查询单条记录，查询结果直接以目标JavaBean返回，查询将以预编译方式运行
     * 
     * @param <T>
     * @param sql
     *            SQL语句
     * @param clazz
     *            目标JavaBean的Class
     * @param params
     *            查询参数
     * @return
     * @throws SQLException
     */
    public <T> T querySingle(String sql, Class<T> clazz, Object... params) throws SQLException {
        ResultSetHandler<T> handler = new BeanHandler<T>(clazz);
        return runner.query(connection, sql, handler, params);
    }
    
    /**
     * 查询多条记录，查询结果将以目标JaveBean的List返回，查询将以预编译的方式运行
     * 
     * @param <T>
     * @param sql
     *            SQL语句
     * @param clazz
     *            目标JavaBean的Class
     * @param params
     *            查询参数
     * @return
     * @throws SQLException
     */
    public <T> List<T> query(String sql, Class<T> clazz, Object... params) throws SQLException {
        ResultSetHandler<List<T>> handler = new BeanListHandler<T>(clazz);
        return runner.query(connection, sql, handler, params);
    }
}
