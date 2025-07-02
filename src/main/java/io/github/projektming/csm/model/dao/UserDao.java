package io.github.projektming.csm.model.dao;

import io.github.projektming.csm.model.beans.User;

public interface UserDao {
    public void addUser(User user);
    public void deleteUser(User user);
    public void updateUser(User user);
}
