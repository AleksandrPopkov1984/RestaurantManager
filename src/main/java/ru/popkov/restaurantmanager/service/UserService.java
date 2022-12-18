package ru.popkov.restaurantmanager.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.popkov.restaurantmanager.model.User;
import ru.popkov.restaurantmanager.repository.UserRepository;
import ru.popkov.restaurantmanager.to.UserTo;
import ru.popkov.restaurantmanager.util.UsersUtil;

import java.util.List;

import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNotFound;
import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(repository.save(user), user.id());
    }

    @Transactional
    public void update(UserTo userTo) {
        User user = get(userTo.id());
        User updateUser = UsersUtil.updateFromTo(user, userTo);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public User get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    public List<User> getAll() {
        return repository.getAll();
    }
}
