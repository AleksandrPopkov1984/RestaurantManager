package ru.popkov.restaurantmanager.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.repository.RestaurantRepository;
import ru.popkov.restaurantmanager.to.RestaurantTo;
import ru.popkov.restaurantmanager.util.RestaurantsUtil;

import java.util.List;

import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        checkNotFoundWithId(repository.save(restaurant), restaurant.id());
    }

    @Transactional
    @CacheEvict(value = "restaurants", allEntries = true)
    public void update(RestaurantTo restaurantTo) {
        Restaurant restaurant = get(restaurantTo.id());
        Restaurant updateRestaurant = RestaurantsUtil.updateFromTo(restaurant, restaurantTo);
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Restaurant get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Cacheable("restaurants")
    public List<Restaurant> getAll() {
        return repository.getAll();
    }
}
