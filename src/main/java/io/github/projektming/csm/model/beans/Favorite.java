package io.github.projektming.csm.model.beans;

public class Favorite {
    private Integer favoriteId;
    private Integer userId;
    private Integer restaurantId;
    private String notes;

    // 构造方法
    public Favorite() {}

    public Favorite(Integer favoriteId, Integer userId, Integer restaurantId, String notes) {
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.notes = notes;
    }

    // Getter 和 Setter 方法


    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "favoriteId=" + favoriteId +
                ", userId=" + userId +
                ", restaurantId=" + restaurantId +
                ", notes='" + notes + '\'' +
                '}';
    }
}
