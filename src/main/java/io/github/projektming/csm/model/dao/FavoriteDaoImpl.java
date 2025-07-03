package io.github.projektming.csm.model.dao;

import io.github.projektming.csm.model.beans.Favorite;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
public class FavoriteDaoImpl extends BaseDao implements FavoriteDao {

    private static final Logger logger = Logger.getLogger(FavoriteDaoImpl.class.getName());

    @Override
    public boolean addFavorite(Favorite favorite) {
        String sql = "INSERT INTO Favorites (user_id, restaurant_id, rating) VALUES (?, ?, ?)";
        Object[] params = {
                favorite.getUserId(),
                favorite.getRestaurantId(),
                null // 默认评分为null
        };

        try {
            return executeUpdate(sql, params) > 0;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "添加收藏失败", e);
            return false;
        }
    }

    @Override
    public boolean deleteFavorite(Integer favoriteId) {
        String sql = "DELETE FROM Favorites WHERE favorite_id = ?";
        Object[] params = {favoriteId};

        try {
            return executeUpdate(sql, params) > 0;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "删除收藏失败", e);
            return false;
        }
    }

    @Override
    public boolean deleteFavoriteByUserAndRestaurant(Integer userId, Integer restaurantId) {
        String sql = "DELETE FROM Favorites WHERE user_id = ? AND restaurant_id = ?";
        Object[] params = {userId, restaurantId};

        try {
            return executeUpdate(sql, params) > 0;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "根据用户和餐厅删除收藏失败", e);
            return false;
        }
    }

    @Override
    public boolean updateFavoriteNotes(Integer favoriteId, String notes) {
        String sql = "UPDATE Favorites SET notes = ? WHERE favorite_id = ?";
        Object[] params = {notes, favoriteId};

        try {
            return executeUpdate(sql, params) > 0;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "更新收藏备注失败", e);
            return false;
        }
    }

    @Override
    public List<Favorite> getFavoritesByUserId(Integer userId) {
        String sql = "SELECT * FROM Favorites WHERE user_id = ?";
        List<Favorite> favorites = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    favorites.add(extractFavoriteFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "获取用户收藏列表失败", e);
        }

        return favorites;
    }

    @Override
    public List<Favorite> getFavoritesByRestaurantId(Integer restaurantId) {
        String sql = "SELECT * FROM Favorites WHERE restaurant_id = ?";
        List<Favorite> favorites = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, restaurantId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    favorites.add(extractFavoriteFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "获取餐厅收藏列表失败", e);
        }

        return favorites;
    }

    @Override
    public boolean isRestaurantFavoriteByUser(Integer userId, Integer restaurantId) {
        String sql = "SELECT COUNT(*) FROM Favorites WHERE user_id = ? AND restaurant_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, restaurantId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "检查收藏状态失败", e);
        }

        return false;
    }

    @Override
    public Favorite getFavoriteById(Integer favoriteId) {
        String sql = "SELECT * FROM Favorites WHERE favorite_id = ?";
        Favorite favorite = null;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, favoriteId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    favorite = extractFavoriteFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "根据ID获取收藏失败", e);
        }

        return favorite;
    }

    @Override
    public Favorite getFavoriteByUserAndRestaurant(Integer userId, Integer restaurantId) {
        String sql = "SELECT * FROM Favorites WHERE user_id = ? AND restaurant_id = ?";
        Favorite favorite = null;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, restaurantId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    favorite = extractFavoriteFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "获取用户对餐厅的收藏失败", e);
        }

        return favorite;
    }

    // 辅助方法：从ResultSet中提取Favorite对象
    private Favorite extractFavoriteFromResultSet(ResultSet rs) throws SQLException {
        Favorite favorite = new Favorite();
        favorite.setFavoriteId(rs.getInt("favorite_id"));
        favorite.setUserId(rs.getInt("user_id"));
        favorite.setRestaurantId(rs.getInt("restaurant_id"));
        favorite.setRating(rs.getBigDecimal("rating"));
        return favorite;
    }
    @Override
    public boolean updateFavoriteRating(Integer favoriteId, BigDecimal rating) {
        String sql = "UPDATE Favorites SET rating = ? WHERE favorite_id = ?";
        Object[] params = {rating, favoriteId};

        try {
            return executeUpdate(sql, params) > 0;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "更新收藏评分失败", e);
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> getFavoriteDetailsByUserId(Integer userId) {
        String sql = "SELECT f.*, r.name as restaurant_name, r.description as restaurant_description " +
                "FROM Favorites f " +
                "JOIN Restaurants r ON f.restaurant_id = r.restaurant_id " +
                "WHERE f.user_id = ?";
        List<Map<String, Object>> favoriteDetails = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                ResultSetMetaData md = rs.getMetaData();
                int columns = md.getColumnCount();
                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>(columns);
                    for (int i = 1; i <= columns; ++i) {
                        row.put(md.getColumnLabel(i), rs.getObject(i));
                    }
                    favoriteDetails.add(row);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "获取用户收藏详情列表失败", e);
        }

        return favoriteDetails;
    }
}
