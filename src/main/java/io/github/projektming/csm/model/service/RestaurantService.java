package io.github.projektming.csm.model.service;

import io.github.projektming.csm.model.beans.Restaurant;
import io.github.projektming.csm.model.beans.User;

public interface RestaurantService {
    Restaurant getRandomRestaurant();

    Restaurant getRandomRestaurant(User user);
}
