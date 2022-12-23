package ru.popkov.restaurantmanager.service.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.Menu;
import ru.popkov.restaurantmanager.service.AbstractServiceTest;
import ru.popkov.restaurantmanager.service.MenuService;
import ru.popkov.restaurantmanager.util.exception.NotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.popkov.restaurantmanager.MenuTestData.*;
import static ru.popkov.restaurantmanager.RestaurantTestData.RESTAURANT1_ID;

public class MenuServiceTest extends AbstractServiceTest {

    @Autowired
    private MenuService service;

    @Test
    void get() {
        Menu menu = service.get(MENU1_ID);
        MENU_MATCHER.assertMatch(menu, menu1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    void getAll() {
        List<Menu> all = service.getAll();
        MENU_MATCHER.assertMatch(all, menus);
    }

    @Test
    void delete() {
        service.delete(MENU1_ID);
        assertThrows(NotFoundException.class, () -> service.get(MENU1_ID));
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND));
    }

    @Test
    void create() {
        Menu created = service.create(getNew(), RESTAURANT1_ID + 1);
        int newId = created.id();
        Menu newMenu = getNew();
        newMenu.setId(newId);
        MENU_MATCHER.assertMatch(created, newMenu);
        MENU_MATCHER.assertMatch(service.get(newId), newMenu);
    }

    @Test
    void update() {
        Menu updated = getUpdated();
        service.update(updated, RESTAURANT1_ID + 4);
        MENU_MATCHER.assertMatch(service.get(MENU1_ID), updated);
    }

    @Test
    void getOfRestaurant() {
        List<Menu> allAfRestaurant = service.getOfRestaurant(RESTAURANT1_ID);
        MENU_MATCHER.assertMatch(allAfRestaurant, menu1);
    }
}
