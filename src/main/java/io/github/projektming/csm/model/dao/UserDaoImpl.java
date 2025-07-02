package com.example.demo.model.dao;

import com.example.demo.model.beans.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public void addUser(User user) throws SQLException {
        Connection conn = getConnection();
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(User user) {
    }
}
