package ru.popkov.restaurantmanager.to;

import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.model.Restaurant;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class MenuTo extends BaseTo {

    @NotNull
    private final LocalDate date;

    @NotNull
    private final Restaurant restaurant;

    private final List<Meal> meals;

    public MenuTo(Integer id, LocalDate date, Restaurant restaurant, List<Meal> meals) {
        super(id);
        this.date = date;
        this.restaurant = restaurant;
        this.meals = meals;
    }

    public LocalDate getDate() {
        return date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<Meal> getMeals() {
        return meals;
    }
}
