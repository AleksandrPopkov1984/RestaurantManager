package ru.popkov.restaurantmanager.service.datajpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.RegularUser;
import ru.popkov.restaurantmanager.service.AbstractServiceTest;
import ru.popkov.restaurantmanager.service.RegularUserService;
import ru.popkov.restaurantmanager.util.exception.NotFoundException;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static ru.popkov.restaurantmanager.UserTestData.*;

public class RegularUserServiceTest extends AbstractServiceTest {

    @Autowired
    private RegularUserService service;

    @Test
    public void get() {
        RegularUser regularUser = service.get(USER1_ID);
        USER_MATCHER.assertMatch(regularUser, user1);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    public void getAll() {
        List<RegularUser> all = service.getAll();
        USER_MATCHER.assertMatch(all, users);
    }

    @Test
    public void delete() {
        service.delete(USER1_ID);
        assertThrows(NotFoundException.class, () -> service.get(USER1_ID));
    }

    @Test
    public void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND));
    }

    @Test
    public void create() {
        RegularUser created = service.create(getNew());
        int newId = created.id();
        RegularUser newUser = getNew();
        newUser.setId(newId);
        USER_MATCHER.assertMatch(created, newUser);
        USER_MATCHER.assertMatch(service.get(newId), newUser);
    }

    @Test
    public void update() {
        RegularUser updated = getUpdated();
        service.update(updated);
        USER_MATCHER.assertMatch(service.get(USER1_ID), updated);
    }
}