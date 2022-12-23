package ru.popkov.restaurantmanager.web.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.service.MenuService;
import ru.popkov.restaurantmanager.to.MenuTo;
import ru.popkov.restaurantmanager.util.MenusUtil;

import java.util.List;

public abstract class AbstractMenuController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService service;

    public List<MenuTo> getOfRestaurant(int restaurantId) {
        log.info("get of restaurant with id {}", restaurantId);
        return MenusUtil.getTos(service.getOfRestaurant(restaurantId));
    }
}
