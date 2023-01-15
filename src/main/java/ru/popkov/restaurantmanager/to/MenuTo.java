package ru.popkov.restaurantmanager.to;

import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.model.Restaurant;

import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.util.List;

public class MenuTo extends BaseTo {

    @NotNull
    private LocalDate date;

    private Restaurant restaurant;

    private List<Meal> meals;

    @ConstructorProperties({"id", "date", "restaurant", "meals"})
    public MenuTo(Integer id, LocalDate date, Restaurant restaurant, List<Meal> meals) {
        super(id);
        this.date = date;
        this.restaurant = restaurant;
        this.meals = meals;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "MenuTo{" +
                "date=" + date +
                ", id=" + id +
                '}';
    }
}
