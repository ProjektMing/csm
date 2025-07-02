package io.github.projektming.csm.model.dao;

import io.github.projektming.csm.model.beans.Restaurant;
import io.github.projektming.csm.util.SqlConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestaurantDaoImpl extends BaseDao implements RestaurantDao {

    private static final Logger logger = Logger.getLogger(RestaurantDaoImpl.class.getName());

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT * FROM restaurants";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = SqlConnector.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantId(rs.getInt("restaurant_id"));
                restaurant.setName(rs.getString("name"));
                restaurant.setDescription(rs.getString("description"));
                restaurant.setImageUrl(rs.getString("image_url"));
                restaurant.setCategories(rs.getString("categories"));
                restaurant.setFlavors(rs.getString("flavors"));
                restaurant.setOpeningTime(rs.getTime("opening_time"));
                restaurant.setClosingTime(rs.getTime("closing_time"));
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching all restaurants", e);
        } finally {
            SqlConnector.closeAll(conn, pstmt, rs);
        }

        return restaurants;
    }
}

