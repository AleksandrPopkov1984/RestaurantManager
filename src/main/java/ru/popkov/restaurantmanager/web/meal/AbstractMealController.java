package ru.popkov.restaurantmanager.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.model.Menu;
import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.service.MealService;
import ru.popkov.restaurantmanager.service.MenuService;
import ru.popkov.restaurantmanager.service.RestaurantService;
import ru.popkov.restaurantmanager.to.MealTo;
import ru.popkov.restaurantmanager.util.MealsUtil;

import java.math.BigDecimal;
import java.util.List;

import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNew;

public class AbstractMealController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService mealService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RestaurantService restaurantService;

    public List<MealTo> getOfMenu(int menuId) {
        log.info("get of menu with id {}", menuId);
        return MealsUtil.getTos(mealService.getOfMenu(menuId));
    }

    public MealTo get(int id) {
        log.info("get {}", id);
        return MealsUtil.createTo(mealService.get(id));
    }

    public void update(Meal meal, int id) {
        log.info("update {} with id {}", meal, id);
        mealService.update(meal, id);
    }

    public void update(MealTo mealTo, int id) {
        log.info("update {} with id {}", mealTo, id);
        mealService.update(mealTo, id);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        mealService.delete(id);
    }

    public Meal create(Meal meal, int menuId) {
        log.info("create {}", meal);
        checkNew(meal);
        return mealService.create(meal, menuId);
    }

    public void create(MealTo mealTo, int menuId) {
        log.info("create {}", mealTo);
        checkNew(mealTo);
        mealService.create(MealsUtil.createNewFromTo(mealTo), menuId);
    }

    public Menu getMenu(int menuId) {
        return menuService.get(menuId);
    }

    public void addDefaultMealIfNecessary(int menuId) {
        List<Meal> meals = mealService.getOfMenu(menuId);
        if (meals.isEmpty()) {
            Meal meal = new Meal(null, "default meal", BigDecimal.valueOf(100));
            mealService.create(meal, menuId);
        }
    }

    public Restaurant getRestaurant(int menuId) {
        Menu menu = menuService.get(menuId);
        return restaurantService.get(menu.getRestaurant().getId());
    }

    public List<MealTo> getActualMenuOfRestaurant(int restaurantId) {
        return MealsUtil.getTos(mealService.getOfRestaurant(restaurantId));
    }
}
