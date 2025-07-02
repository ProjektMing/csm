package io.github.projektming.csm.model.dao;

import io.github.projektming.csm.model.beans.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        Object[] params = {user.getUsername(), user.getPassword()};
        executeUpdate(sql, params);

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
}
