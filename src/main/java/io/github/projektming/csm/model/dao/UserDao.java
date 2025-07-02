package com.example.demo.model.dao;

import com.example.demo.model.beans.User;

import java.sql.SQLException;

public interface UserDao {
    public void addUser(User user) throws SQLException;
    public void deleteUser(User user);
    public void updateUser(User user);
}
