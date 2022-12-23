package ru.popkov.restaurantmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.popkov.restaurantmanager.model.Menu;
import ru.popkov.restaurantmanager.repository.MenuRepository;

import java.util.List;

import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MenuService {

    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public Menu create(Menu menu, int restaurantId) {
        Assert.notNull(menu, "menu must not be null");
        return repository.save(menu, restaurantId);
    }

    public void update(Menu menu, int restaurantId) {
        Assert.notNull(menu, "menu must not be mull");
        checkNotFoundWithId(repository.save(menu, restaurantId), menu.id());
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Menu get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Menu> getAll() {
        return repository.getAll();
    }

    public List<Menu> getOfRestaurant(int restaurantId) {
        return repository.getOfRestaurant(restaurantId);
    }
}
