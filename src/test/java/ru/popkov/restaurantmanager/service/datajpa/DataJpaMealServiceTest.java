package ru.popkov.restaurantmanager.service.datajpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.MealTestData;
import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.service.AbstractRepositoryTest;
import ru.popkov.restaurantmanager.service.MealService;
import ru.popkov.restaurantmanager.util.exception.NotFoundException;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static ru.popkov.restaurantmanager.MealTestData.*;
import static ru.popkov.restaurantmanager.MealTestData.getUpdated;
import static ru.popkov.restaurantmanager.RestaurantTestData.RESTAURANT1_ID;

public class DataJpaMealServiceTest extends AbstractRepositoryTest {

    @Autowired
    private MealService service;

    @Test
    public void get() {
        Meal meal = service.get(MEAL1_ID);
        System.out.println(meal);
        System.out.println(MealTestData.meal1);
        MEAL_MATCHER.assertMatch(meal, MealTestData.meal1);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    public void getAll() {
        List<Meal> all = service.getAll();
        MEAL_MATCHER.assertMatch(all, meals);
    }

    @Test
    public void delete() {
        service.delete(MEAL1_ID);
        assertThrows(NotFoundException.class, () -> service.get(MEAL1_ID));
    }

    @Test
    public void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    public void create() {
        Meal created = service.create(getNew(), RESTAURANT1_ID);
        int newId = created.id();
        Meal newMeal = getNew();
        newMeal.setId(newId);
        MEAL_MATCHER.assertMatch(created, newMeal);
        MEAL_MATCHER.assertMatch(service.get(newId), newMeal);
    }

    @Test
    public void update() {
        Meal updated = getUpdated();
        service.update(updated, RESTAURANT1_ID);
        MEAL_MATCHER.assertMatch(service.get(MEAL1_ID), getUpdated());
    }
}
