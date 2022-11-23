package ru.popkov.restaurantmanager.repository.datajpa;

import org.springframework.stereotype.Repository;
import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.repository.MealRepository;

import java.util.List;

@Repository
public class DataJpaMealRepository implements MealRepository {

    private final CrudMealRepository crudMealRepository;

    public DataJpaMealRepository(CrudMealRepository crudMealRepository) {
        this.crudMealRepository = crudMealRepository;
    }

    @Override
    public Meal save(Meal meal) {
        return crudMealRepository.save(meal);
    }

    @Override
    public boolean delete(int id) {
        return crudMealRepository.delete(id) != 0;
    }

    @Override
    public Meal get(int id) {
        return crudMealRepository.findById(id).orElse(null);
    }

    @Override
    public List<Meal> getAll() {
        return crudMealRepository.findAll();
    }

    @Override
    public List<Meal> getOfRestaurant(int restaurantId) {
        return crudMealRepository.getOfRestaurant(restaurantId);
    }
}
