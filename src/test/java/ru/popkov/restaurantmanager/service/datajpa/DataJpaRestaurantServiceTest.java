package ru.popkov.restaurantmanager.service.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.service.AbstractServiceTest;
import ru.popkov.restaurantmanager.service.RestaurantService;
import ru.popkov.restaurantmanager.util.exception.NotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.popkov.restaurantmanager.RestaurantTestData.*;

public class DataJpaRestaurantServiceTest extends AbstractServiceTest {

    @Autowired
    private RestaurantService service;

    @Test
    void get() {
        Restaurant restaurant = service.get(RESTAURANT1_ID);
        RESTAURANT_MATCHER.assertMatch(restaurant, restaurant1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    void getAll() {
        List<Restaurant> all = service.getAll();
        RESTAURANT_MATCHER.assertMatch(all, restaurants);
    }

    @Test
    void delete() {
        service.delete(RESTAURANT1_ID);
        assertThrows(NotFoundException.class, () -> service.get(RESTAURANT1_ID));
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND));
    }

    @Test
    void create() {
        Restaurant created = service.create(getNew());
        int newId = created.id();
        Restaurant newRestaurant = getNew();
        newRestaurant.setId(newId);
        RESTAURANT_MATCHER.assertMatch(created, newRestaurant);
        RESTAURANT_MATCHER.assertMatch(service.get(newId), newRestaurant);
    }

    @Test
    void update() {
        Restaurant updated = getUpdated();
        service.update(updated);
        RESTAURANT_MATCHER.assertMatch(service.get(RESTAURANT1_ID), getUpdated());
    }
}