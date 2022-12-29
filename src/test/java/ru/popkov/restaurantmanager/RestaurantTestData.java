package ru.popkov.restaurantmanager;

import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.to.RestaurantTo;

import java.util.List;

import static ru.popkov.restaurantmanager.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {

    public static final MatcherFactory.Matcher<Restaurant> RESTAURANT_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Restaurant.class, "menus", "votes");
    public static final MatcherFactory.Matcher<RestaurantTo> RESTAURANT_TO_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(RestaurantTo.class, "");

    public static final int NOT_FOUND = 10;
    public static final int RESTAURANT1_ID = START_SEQ + 7;

    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT1_ID, "Metropol");
    public static final Restaurant restaurant2 = new Restaurant(RESTAURANT1_ID + 1, "Tokio");
    public static final Restaurant restaurant3 = new Restaurant(RESTAURANT1_ID + 2, "Art-Caviar");
    public static final Restaurant restaurant4 = new Restaurant(RESTAURANT1_ID + 3, "Karl and Fridrich");
    public static final Restaurant restaurant5 = new Restaurant(RESTAURANT1_ID + 4, "Russian fishing");

    public static final List<Restaurant> restaurants = List.of(restaurant1, restaurant2, restaurant3, restaurant4, restaurant5);

    public static final RestaurantTo restaurantTo = new RestaurantTo(RESTAURANT1_ID, "Metropol", 1);
    public static final RestaurantTo newRestaurantTo = new RestaurantTo(null, "", 0);
    public static final RestaurantTo updatedRestaurantTo = new RestaurantTo(RESTAURANT1_ID, restaurant1.getName() + " Luxe", 1);

    public static final RestaurantTo restaurantTo1 = new RestaurantTo(RESTAURANT1_ID, "Metropol", 1);
    public static final RestaurantTo restaurantTo2 = new RestaurantTo(RESTAURANT1_ID + 1, "Tokio", 0);
    public static final RestaurantTo restaurantTo3 = new RestaurantTo(RESTAURANT1_ID + 2, "Art-Caviar", 0);
    public static final RestaurantTo restaurantTo4 = new RestaurantTo(RESTAURANT1_ID + 3, "Karl and Fridrich", 1);
    public static final RestaurantTo restaurantTo5 = new RestaurantTo(RESTAURANT1_ID + 4, "Russian fishing", 0);

    public static final List<RestaurantTo> restaurantsTo = List.of(restaurantTo1, restaurantTo2, restaurantTo3,
            restaurantTo4, restaurantTo5);

    public static Restaurant getNew() {
        return new Restaurant(null, "New");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT1_ID, restaurant1.getName() + " Luxe");
    }
}
