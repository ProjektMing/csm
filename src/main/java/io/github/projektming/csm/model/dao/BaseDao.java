package io.github.projektming.csm.model.dao;

import io.github.projektming.csm.util.SqlConnector;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDao {

    protected static final Logger logger = Logger.getLogger(BaseDao.class.getName());

    static Connection getConnection() {
        return SqlConnector.getConnection();
    }
    static void closeConnection(Connection conn) {
        SqlConnector.closeAll(conn,null,null);
    }

    // 通用的更新方法 (INSERT, UPDATE, DELETE)
    public int executeUpdate(String sql, Object[] params) {
        int affectedRows = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = SqlConnector.getConnection();
            pstmt = conn.prepareStatement(sql);

            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            affectedRows = pstmt.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error executing update: " + sql, e);
        } finally {
            SqlConnector.closeAll(conn, pstmt, null);
        }

        return affectedRows;
    }

    // 通用的查询方法 (SELECT)
    // 注意：此方法将连接的管理责任转移给了调用者，
    // 调用者在使用完 ResultSet 和 PreparedStatement 后必须手动关闭它们和连接。
    public ResultSet executeQuery(Connection conn, String sql, Object[] params) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        }
        return pstmt.executeQuery();
    }
}
