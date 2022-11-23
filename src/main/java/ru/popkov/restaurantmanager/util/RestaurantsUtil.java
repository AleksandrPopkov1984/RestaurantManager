package ru.popkov.restaurantmanager.util;

import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.to.RestaurantTo;

import java.util.List;

public class RestaurantsUtil {

    public static List<RestaurantTo> getRestaurantsTo(List<Restaurant> restaurants) {
        return restaurants.stream()
                .map(RestaurantsUtil::createRestaurantTo)
                .toList();
    }

    public static RestaurantTo createRestaurantTo(Restaurant restaurant) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName());
    }
}
