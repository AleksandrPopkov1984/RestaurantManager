package ru.popkov.restaurantmanager.repository;

import ru.popkov.restaurantmanager.model.Meal;

import java.util.List;

public interface MealRepository {

    Meal save(Meal meal, int menuId);

    boolean delete(int id);

    Meal get(int id);

    List<Meal> getAll();

    List<Meal> getOfMenu(int menuId);

    List<Meal> getOfRestaurant(int restaurantId);
}
