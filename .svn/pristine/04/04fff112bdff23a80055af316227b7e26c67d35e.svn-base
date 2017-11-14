package com.uk.sec.framework.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

/**
 * 执行SQL的工具类
 * 
 * @version 1.0
 */
public class SqlUtils {
    
    private static QueryRunner runner           = new QueryRunner();
    
    static MapListHandler      MAP_LIST_HANDLER = new MapListHandler(new RowConverter());
    static MapHandler          MAP_HANDLER      = new MapHandler(new RowConverter());
    
    /**
     * 获取SqlExecutor实例，用于在单一数据库连接下执行多个操作以及事务相关操作
     * 
     * @return
     * @throws SQLException
     */
    public static SqlExecutor newSqlExecutor() throws SQLException {
        return new SqlExecutor();
    }
    
    /**
     * 获取SqlExecutor实例，用于在单一数据库连接下执行多个操作以及事务相关操作，用户可以指定 要使用的Connection
     * 
     * @param conn
     *            SqlExecutor执行时要使用的Connection
     * @return
     * @throws SQLException
     */
    public static SqlExecutor newSqlExecutor(Connection conn) throws SQLException {
        return new SqlExecutor(conn);
    }
    
    /**
     * 预编译执行更新，插入等操作
     * 
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static int update(String sql, Object... params) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionManager.getInstance().getConnection();
            return runner.update(conn, sql, params);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    /**
     * 预编译执行查询
     * 
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static List<Map<String, Object>> select(String sql, Object... params) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionManager.getInstance().getConnection();
            return runner.query(conn, sql, MAP_LIST_HANDLER, params);
        } finally {
            DbUtils.close(conn);
        }
    }
    
    /**
     * 预编译执行查询，该查询只返回第一个查询的结果
     * 
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static Map<String, Object> selectSingle(String sql, Object... params) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionManager.getInstance().getConnection();
            return runner.query(conn, sql, MAP_HANDLER, params);
        } finally {
            DbUtils.close(conn);
        }
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
    public static <T> T querySingle(String sql, Class<T> clazz, Object... params) throws SQLException {
        ResultSetHandler<T> handler = new BeanHandler<T>(clazz);
        Connection conn = null;
        try {
            conn = ConnectionManager.getInstance().getConnection();
            QueryRunner query = new QueryRunner();
            return query.query(conn, sql, handler, params);
        } finally {
            DbUtils.close(conn);
        }
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
    public static <T> List<T> query(String sql, Class<T> clazz, Object... params) throws SQLException {
        ResultSetHandler<List<T>> handler = new BeanListHandler<T>(clazz);
        Connection conn = null;
        try {
            conn = ConnectionManager.getInstance().getConnection();
            QueryRunner query = new QueryRunner();
            return query.query(conn, sql, handler, params);
        } finally {
            DbUtils.close(conn);
        }
    }
    
    /**
     * DbUtils包中的BasicRowProcessor转换Map的时候键用的是列的名字而不是label，
     * 这样会使SQL语句中的重命名失效，因此重新改写了toMap方法，改用label作为键
     * 
     * @author xzw
     */
    private static class RowConverter extends BasicRowProcessor {
        
        public Map<String, Object> toMap(ResultSet rs) throws SQLException {
            Map<String, Object> result = new CaseInsensitiveHashMap();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            
            for (int i = 1; i <= cols; i++) {
                result.put(rsmd.getColumnLabel(i), rs.getObject(i));
            }
            
            return result;
        }
        
    }
    
    /**
     * 大小写不敏感的Map，由于SQL语句里的列名是大小写不敏感的，为了符合这一习惯，写了这个大小写不敏感 的Map
     * 
     * @author kliu
     */
    private static class CaseInsensitiveHashMap extends HashMap<String, Object> {
        
        private final Map<String, String> lowerCaseMap     = new HashMap<String, String>();
        
        private static final long         serialVersionUID = 1L;
        
        @Override
        public boolean containsKey(Object key) {
            Object realKey = lowerCaseMap.get(key.toString().toLowerCase());
            return super.containsKey(realKey);
        }
        
        @Override
        public Object get(Object key) {
            Object realKey = lowerCaseMap.get(key.toString().toLowerCase());
            return super.get(realKey);
        }
        
        @Override
        public Object put(String key, Object value) {
            Object oldKey = lowerCaseMap.put(key.toLowerCase(), key);
            Object oldValue = super.remove(oldKey);
            super.put(key, value);
            return oldValue;
        }
        
        @Override
        public void putAll(Map<? extends String, ?> m) {
            for (Map.Entry<? extends String, ?> entry : m.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                this.put(key, value);
            }
        }
        
        @Override
        public Object remove(Object key) {
            Object realKey = lowerCaseMap.remove(key.toString().toLowerCase());
            return super.remove(realKey);
        }
    }
}
