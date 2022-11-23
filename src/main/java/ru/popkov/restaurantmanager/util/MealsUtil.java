package ru.popkov.restaurantmanager.util;

import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.to.MealTo;

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
        return new MealTo(meal.getId(), meal.getName(), meal.getPrice(), meal.getRestaurant());
    }
}
