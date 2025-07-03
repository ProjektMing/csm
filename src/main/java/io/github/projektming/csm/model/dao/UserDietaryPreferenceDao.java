package io.github.projektming.csm.model.dao;

import io.github.projektming.csm.model.beans.UserDietaryPreference;

import java.util.List;

public interface UserDietaryPreferenceDao {
    List<UserDietaryPreference> findByUserId(int userId);
}

