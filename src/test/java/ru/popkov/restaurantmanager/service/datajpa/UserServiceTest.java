package ru.popkov.restaurantmanager.service.datajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.dao.DataAccessException;
import ru.popkov.restaurantmanager.model.Role;
import ru.popkov.restaurantmanager.model.User;
import ru.popkov.restaurantmanager.service.AbstractServiceTest;
import ru.popkov.restaurantmanager.service.UserService;
import ru.popkov.restaurantmanager.util.exception.NotFoundException;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.popkov.restaurantmanager.UserTestData.*;

public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService service;

    @Test
    void get() {
        User user = service.get(USER1_ID);
        USER_MATCHER.assertMatch(user, user1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    void getAll() {
        List<User> all = service.getAll();
        USER_MATCHER.assertMatch(all, users);
    }

    @Test
    void delete() {
        service.delete(USER1_ID);
        assertThrows(NotFoundException.class, () -> service.get(USER1_ID));
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND));
    }

    @Test
    void create() {
        User created = service.create(getNew());
        int newId = created.id();
        User newUser = getNew();
        newUser.setId(newId);
        USER_MATCHER.assertMatch(created, newUser);
        USER_MATCHER.assertMatch(service.get(newId), newUser);
    }

    @Test
    void duplicateMailCreate() {
        assertThrows(DataAccessException.class, () ->
                service.create(new User(null, "DuplicateSurname", "DuplicateName", "admin@gmail.com", "password")));
    }

    @Test
    void update() {
        User updated = getUpdated();
        service.update(updated);
        USER_MATCHER.assertMatch(service.get(USER1_ID), updated);
    }

    @Test
    void createWithException() {
        validateRootCause(ConstraintViolationException.class, () -> service.create(new User(null, "  ", "Ivan", "ivan@gmail.com", "password", Role.USER)));
        validateRootCause(ConstraintViolationException.class, () -> service.create(new User(null, "Ivanov", "  ", "ivan@gmail.com", "password", Role.USER)));
        validateRootCause(ConstraintViolationException.class, () -> service.create(new User(null, "Ivanov", "  ", "ivan@gmail.com", "password", Role.USER)));
        validateRootCause(ConstraintViolationException.class, () -> service.create(new User(null, "Ivanov", "Ivan", "  ", "password", Role.USER)));
        validateRootCause(ConstraintViolationException.class, () -> service.create(new User(null, "Ivanov", "Ivan", "ivan@gmail.com", "1234", Role.USER)));
    }

    @Test
    void enable() {
        service.enable(USER1_ID, false);
        assertFalse(service.get(USER1_ID).isEnabled());
        service.enable(USER1_ID, true);
        assertTrue(service.get(USER1_ID).isEnabled());
    }
}