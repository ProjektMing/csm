package io.github.projektming.csm.model.beans;

import java.math.BigDecimal;

public class Favorite {
    private int favoriteId;
    private int userId;
    private int restaurantId;
    private BigDecimal rating;

    // 构造方法
    public Favorite() {}

    public Favorite(int favoriteId, int userId, int restaurantId, BigDecimal rating) {
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.rating = rating;
    }

    // Getter 和 Setter 方法


    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "favoriteId=" + favoriteId +
                ", userId=" + userId +
                ", restaurantId=" + restaurantId +
                ", rating=" + rating +
                '}';
    }
}
