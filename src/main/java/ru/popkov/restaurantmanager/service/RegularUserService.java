package ru.popkov.restaurantmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.popkov.restaurantmanager.model.RegularUser;
import ru.popkov.restaurantmanager.repository.RegularUserRepository;

import java.util.List;

import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNotFound;
import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RegularUserService {

    private final RegularUserRepository repository;

    public RegularUserService(RegularUserRepository repository) {
        this.repository = repository;
    }

    public RegularUser create(RegularUser regularUser) {
        Assert.notNull(regularUser, "user must not be null");
        return repository.save(regularUser);
    }

    public void update(RegularUser regularUser) {
        Assert.notNull(regularUser, "user must not be null");
        checkNotFoundWithId(repository.save(regularUser), regularUser.id());
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public RegularUser get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public RegularUser getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    public List<RegularUser> getAll() {
        return repository.getAll();
    }
}
