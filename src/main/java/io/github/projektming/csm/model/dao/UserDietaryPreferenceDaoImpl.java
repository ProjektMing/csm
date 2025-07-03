package io.github.projektming.csm.model.dao;

import io.github.projektming.csm.model.beans.UserDietaryPreference;
import io.github.projektming.csm.util.SqlConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDietaryPreferenceDaoImpl extends BaseDao implements UserDietaryPreferenceDao {
    @Override
    public List<UserDietaryPreference> findByUserId(int userId) {
        List<UserDietaryPreference> preferences = new ArrayList<>();
        String sql = "SELECT * FROM user_dietary_preferences WHERE user_id = ?";
        try (Connection conn = SqlConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    UserDietaryPreference preference = new UserDietaryPreference();
                    preference.setPreferenceId(rs.getInt("preference_id"));
                    preference.setUserId(rs.getInt("user_id"));
                    preference.setPreferenceTypeId(rs.getInt("preference_type_id"));
                    preference.setPreferenceLevel(rs.getShort("preference_level"));
                    preferences.add(preference);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preferences;
    }
}

