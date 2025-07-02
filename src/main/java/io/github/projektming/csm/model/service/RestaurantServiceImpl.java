package io.github.projektming.csm.model.service;

import io.github.projektming.csm.model.beans.Restaurant;
import io.github.projektming.csm.model.dao.RestaurantDao;
import io.github.projektming.csm.model.dao.RestaurantDaoImpl;

import java.util.List;
import java.util.Random;

public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantDao restaurantDao = new RestaurantDaoImpl();

    @Override
    public Restaurant getRandomRestaurant() {
        List<Restaurant> allRestaurants = restaurantDao.getAllRestaurants();
        if (allRestaurants == null || allRestaurants.isEmpty()) {
            return null; // Or throw an exception
        }
        Random rand = new Random();
        return allRestaurants.get(rand.nextInt(allRestaurants.size()));
    }
}

