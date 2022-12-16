package ru.popkov.restaurantmanager.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.service.RestaurantService;
import ru.popkov.restaurantmanager.to.RestaurantTo;
import ru.popkov.restaurantmanager.util.RestaurantsUtil;

import java.util.List;

import static ru.popkov.restaurantmanager.util.ValidationUtil.assureIdConsistent;
import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNew;

public abstract class AbstractRestaurantController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService service;

    public List<RestaurantTo> getAll() {
        log.info("getAll");
        return RestaurantsUtil.getTos(service.getAll());
    }

    public Restaurant get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public Restaurant create(Restaurant restaurant) {
        log.info("create {}", restaurant);
        checkNew(restaurant);
        return service.create(restaurant);
    }

    public void update(Restaurant restaurant, int id) {
        log.info("update {} with id {}", restaurant, id);
        assureIdConsistent(restaurant, id);
        service.update(restaurant);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }
}
