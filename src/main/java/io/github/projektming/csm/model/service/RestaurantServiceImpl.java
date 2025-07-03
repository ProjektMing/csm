package io.github.projektming.csm.model.service;

import io.github.projektming.csm.model.beans.Restaurant;
import io.github.projektming.csm.model.beans.User;
import io.github.projektming.csm.model.beans.UserDietaryPreference;
import io.github.projektming.csm.model.dao.RestaurantDao;
import io.github.projektming.csm.model.dao.RestaurantDaoImpl;
import io.github.projektming.csm.model.dao.UserDietaryPreferenceDao;
import io.github.projektming.csm.model.dao.UserDietaryPreferenceDaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantDao restaurantDao = new RestaurantDaoImpl();
    private final UserDietaryPreferenceDao userDietaryPreferenceDao = new UserDietaryPreferenceDaoImpl();

    @Override
    public Restaurant getRandomRestaurant() {
        List<Restaurant> allRestaurants = restaurantDao.getAllRestaurants();
        if (allRestaurants == null || allRestaurants.isEmpty()) {
            return null; // Or throw an exception
        }
        Random rand = new Random();
        return allRestaurants.get(rand.nextInt(allRestaurants.size()));
    }

    @Override
    public Restaurant getRandomRestaurant(User user) {
        List<Restaurant> allRestaurants = restaurantDao.getAllRestaurants();
        if (allRestaurants == null || allRestaurants.isEmpty()) {
            return null; // Or throw an exception
        }

        List<UserDietaryPreference> preferences = userDietaryPreferenceDao.findByUserId(user.getUserId());

        // If user has no preferences, return a random restaurant
        if (preferences == null || preferences.isEmpty()) {
            return getRandomRestaurant();
        }

        Map<Restaurant, Double> weightedRestaurants = new HashMap<>();
        double totalWeight = 0;

        for (Restaurant restaurant : allRestaurants) {
            double score = 1.0; // Base score
            for (UserDietaryPreference preference : preferences) {
                // This is a simplified example. You might want to have a more complex logic
                // to match preference_type_id with restaurant properties (e.g., categories, flavors).
                // For now, we'll just boost the score based on the preference level.
                if (restaurant.getCategories().contains(String.valueOf(preference.getPreferenceTypeId()))) {
                    score += preference.getPreferenceLevel();
                }
            }
            weightedRestaurants.put(restaurant, score);
            totalWeight += score;
        }

        double randomValue = new Random().nextDouble() * totalWeight;
        double cumulativeWeight = 0;
        for (Map.Entry<Restaurant, Double> entry : weightedRestaurants.entrySet()) {
            cumulativeWeight += entry.getValue();
            if (randomValue <= cumulativeWeight) {
                return entry.getKey();
            }
        }

        return null; // Should not happen if there are restaurants
    }
}
