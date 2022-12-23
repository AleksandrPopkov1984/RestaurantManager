package ru.popkov.restaurantmanager.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.service.MealService;
import ru.popkov.restaurantmanager.to.MealTo;
import ru.popkov.restaurantmanager.util.MealsUtil;

import java.util.List;

public class AbstractMealController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public List<MealTo> getOfMenu(int menuId) {
        log.info("get of menu with id {}", menuId);
        return MealsUtil.getTos(service.getOfMenu(menuId));
    }
}
