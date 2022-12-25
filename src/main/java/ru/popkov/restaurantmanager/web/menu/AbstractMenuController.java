package ru.popkov.restaurantmanager.web.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.model.Menu;
import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.service.MealService;
import ru.popkov.restaurantmanager.service.MenuService;
import ru.popkov.restaurantmanager.service.RestaurantService;
import ru.popkov.restaurantmanager.to.MenuTo;
import ru.popkov.restaurantmanager.util.MenusUtil;

import java.math.BigDecimal;
import java.util.List;

import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNew;

public abstract class AbstractMenuController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private MealService mealService;

    public List<MenuTo> getOfRestaurant(int restaurantId) {
        log.info("get of restaurant with id {}", restaurantId);
        return MenusUtil.getTos(menuService.getOfRestaurant(restaurantId));
    }

    public MenuTo get(int id) {
        log.info("get {}", id);
        return MenusUtil.createTo(menuService.get(id));
    }

    public void delete(int id) {
        log.info("delete {}", id);
        menuService.delete(id);
    }

    public Menu create(Menu menu, int restaurantId) {
        log.info("create {}", menu);
        checkNew(menu);
        return menuService.create(menu, restaurantId);
    }

    public Menu create(MenuTo menuTo, int restaurantId) {
        log.info("create {}", menuTo);
        checkNew(menuTo);
        return menuService.create(MenusUtil.createNewFromTo(menuTo), restaurantId);
    }

    public Restaurant getRestaurant(int restaurantId) {
        return restaurantService.get(restaurantId);
    }

    public Meal createNewMeal(int id) {
        Meal meal = new Meal(null, "default meal", BigDecimal.valueOf(100));
        return mealService.create(meal, id);
    }
}
