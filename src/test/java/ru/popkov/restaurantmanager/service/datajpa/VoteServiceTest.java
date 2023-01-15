package ru.popkov.restaurantmanager.service.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.Vote;
import ru.popkov.restaurantmanager.service.AbstractServiceTest;
import ru.popkov.restaurantmanager.service.VoteService;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static ru.popkov.restaurantmanager.RestaurantTestData.restaurant1;
import static ru.popkov.restaurantmanager.UserTestData.USER1_ID;
import static ru.popkov.restaurantmanager.VoteTestData.*;

public class VoteServiceTest extends AbstractServiceTest {

    @Autowired
    private VoteService service;

    @Test
    void get() {
        Vote vote = service.get(VOTE1_ID);
        VOTE_MATCHER.assertMatch(vote, vote1);
    }

    @Test
    void getOfUserAndDate() {
        int userId = 100005;
        LocalDate date = LocalDate.of(2022, 12, 25);
        Vote vote = service.getOfUserAndDate(userId, date);
        VOTE_MATCHER.assertMatch(vote, vote2);
    }

    @Test
    void create() {
        Vote created = service.create(getNew());
        int newId = created.id();
        Vote newVote = getNew();
        newVote.setId(newId);
        VOTE_MATCHER.assertMatch(created, newVote);
        VOTE_MATCHER.assertMatch(service.get(newId), newVote);
    }

    @Test
    void updateIsPermitted() {
        Vote updated = getUpdated();
        assertTrue(service.update(updated));
        VOTE_MATCHER.assertMatch(service.get(VOTE1_ID), updated);
    }

    @Test
    void updateIsNotPermitted() {
        Vote updated = getUpdatedNotPermitted();
        assertFalse(service.update(updated));
    }

    @Test
    void createWithException() {
        validateRootCause(ConstraintViolationException.class, () -> service.create(new Vote(null, USER1_ID, null,
                LocalDate.of(2022, 12, 25), LocalTime.of(10, 0))));
        validateRootCause(ConstraintViolationException.class, () -> service.create(new Vote(null, USER1_ID, restaurant1,
                LocalDate.of(2122, 12, 25), LocalTime.of(10, 0))));
    }
}
