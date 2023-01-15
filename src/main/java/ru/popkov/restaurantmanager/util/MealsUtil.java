package ru.popkov.restaurantmanager.util;

import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.to.MealTo;
import ru.popkov.restaurantmanager.to.RestaurantTo;

import java.util.List;

public class MealsUtil {

    private MealsUtil() {
    }

    public static List<MealTo> getTos(List<Meal> meals) {
        return meals.stream()
                .map(MealsUtil::createTo)
                .toList();
    }

    public static MealTo createTo(Meal meal) {
        return new MealTo(meal.getId(), meal.getName(), meal.getPrice(), meal.getMenu());
    }

    public static Meal updateFromTo(Meal meal, MealTo mealTo) {
        meal.setName(mealTo.getName());
        meal.setPrice(mealTo.getPrice());
        meal.setMenu(mealTo.getMenu());
        return meal;
    }

    public static Meal createNewFromTo(MealTo mealTo) {
        return new Meal(null, mealTo.getName(), mealTo.getPrice());
    }
}
