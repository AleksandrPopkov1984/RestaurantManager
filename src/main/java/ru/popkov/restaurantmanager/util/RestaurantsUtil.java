package ru.popkov.restaurantmanager.util;

import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.to.RestaurantTo;

import java.util.List;

public class RestaurantsUtil {

    private RestaurantsUtil() {
    }

    public static List<RestaurantTo> getTos(List<Restaurant> restaurants) {
        return restaurants.stream()
                .map(RestaurantsUtil::createTo)
                .toList();
    }

    public static RestaurantTo createTo(Restaurant restaurant) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), getVoteCount(restaurant));
    }

    public static Restaurant createNewFromTo(RestaurantTo restaurantTo) {
        return new Restaurant(null, restaurantTo.getName());
    }

    public static Restaurant updateFromTo(Restaurant restaurant, RestaurantTo restaurantTo) {
        restaurant.setName(restaurantTo.getName());
        return restaurant;
    }

    public static int getVoteCount(Restaurant restaurant) {
        if (restaurant.getVotes() != null) {
            return restaurant.getVotes().size();
        } else {
            return 0;
        }
    }
}
