package ru.popkov.restaurantmanager.service.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.service.AbstractServiceTest;
import ru.popkov.restaurantmanager.service.MealService;
import ru.popkov.restaurantmanager.util.exception.NotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.popkov.restaurantmanager.MealTestData.*;
import static ru.popkov.restaurantmanager.MealTestData.getUpdated;
import static ru.popkov.restaurantmanager.RestaurantTestData.RESTAURANT1_ID;

public class MealServiceTest extends AbstractServiceTest {

    @Autowired
    private MealService service;

    @Test
    void get() {
        Meal meal = service.get(MEAL1_ID);
        MEAL_MATCHER.assertMatch(meal, meal1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    void getAll() {
        List<Meal> all = service.getAll();
        MEAL_MATCHER.assertMatch(all, meals);
    }

    @Test
    void delete() {
        service.delete(MEAL1_ID);
        assertThrows(NotFoundException.class, () -> service.get(MEAL1_ID));
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND));
    }

    @Test
    void create() {
        Meal created = service.create(getNew(), RESTAURANT1_ID);
        int newId = created.id();
        Meal newMeal = getNew();
        newMeal.setId(newId);
        MEAL_MATCHER.assertMatch(created, newMeal);
        MEAL_MATCHER.assertMatch(service.get(newId), newMeal);
    }

    @Test
    void update() {
        Meal updated = getUpdated();
        service.update(updated, RESTAURANT1_ID);
        MEAL_MATCHER.assertMatch(service.get(MEAL1_ID), getUpdated());
    }
}
