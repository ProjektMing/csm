package io.github.projektming.csm.model.dao;

import io.github.projektming.csm.model.beans.User;

public interface UserDao {
    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserById(int userId);

    User getUserByLogin(User user);

}
