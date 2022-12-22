package ru.popkov.restaurantmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.repository.MealRepository;

import java.util.List;

import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(Meal meal, int menuId) {
        Assert.notNull(meal, "meal must not be null");
        return repository.save(meal, menuId);
    }

    public void update(Meal meal, int menuId) {
        Assert.notNull(meal, "meal must not be null");
        checkNotFoundWithId(repository.save(meal, menuId), meal.id());
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Meal get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Meal> getAll() {
        return repository.getAll();
    }

    public List<Meal> getOfMenu(int menuId) {
        return repository.getOfMenu(menuId);
    }
}
