package io.github.projektming.csm.model.dao;

import io.github.projektming.csm.model.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public boolean addUser(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        Object[] params = {user.getUsername(), user.getPassword()};
        return executeUpdate(sql, params) > 0;

    }

    @Override
    public void deleteUser(User user) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        Object[] params = {user.getUserId()};
        executeUpdate(sql, params);

    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET username = ?, password = ? WHERE user_id = ?";
        Object[] params = {user.getUsername(), user.getPassword(), user.getUserId()};
        executeUpdate(sql, params);
    }

    @Override
    public User getUserById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        Object[] params = {userId};
        try (Connection conn = getConnection()) {
            ResultSet rs = executeQuery(conn, sql, params);
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                return user;
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "获取用户失败", e);
        }
        return null;
    }

    @Override
    public User getUserByLogin(User user) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        Object[] params = {user.getUsername(), user.getPassword()};
        try (Connection conn = getConnection();
             ResultSet rs = executeQuery(conn, sql, params)) {
            if (rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                return user;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "用户登录失败", e);
        }
        return null;
    }
}
