package io.github.projektming.csm.model.dao;

import io.github.projektming.csm.model.beans.Favorite;
import java.util.List;

public interface FavoriteDao {
    // 添加收藏
    boolean addFavorite(Favorite favorite);

    // 删除收藏
    boolean deleteFavorite(Integer favoriteId);

    // 根据用户ID和餐厅ID删除收藏
    boolean deleteFavoriteByUserAndRestaurant(Integer userId, Integer restaurantId);

    // 更新收藏备注
    boolean updateFavoriteNotes(Integer favoriteId, String notes);

    // 获取用户的所有收藏
    List<Favorite> getFavoritesByUserId(Integer userId);

    // 获取餐厅的所有收藏
    List<Favorite> getFavoritesByRestaurantId(Integer restaurantId);

    // 检查用户是否收藏了某个餐厅
    boolean isRestaurantFavoriteByUser(Integer userId, Integer restaurantId);

    // 获取特定收藏
    Favorite getFavoriteById(Integer favoriteId);

    // 获取用户对特定餐厅的收藏
    Favorite getFavoriteByUserAndRestaurant(Integer userId, Integer restaurantId);
}
