package ru.popkov.restaurantmanager;

import ru.popkov.restaurantmanager.model.Vote;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static ru.popkov.restaurantmanager.RestaurantTestData.*;
import static ru.popkov.restaurantmanager.UserTestData.USER1_ID;
import static ru.popkov.restaurantmanager.model.AbstractBaseEntity.START_SEQ;
import static ru.popkov.restaurantmanager.service.VoteService.THRESHOLD_TIME_FOR_CHANGING_VOTE;

public class VoteTestData {

    public static final MatcherFactory.Matcher<Vote> VOTE_MATCHER = MatcherFactory.usingIgnoreFieldsComparator("restaurant.menu");

    public static final int VOTE1_ID = START_SEQ + 27;

    public static final Vote vote1 = new Vote(VOTE1_ID, USER1_ID + 2, restaurant1, LocalDate.of(2022, 12, 25), LocalTime.of(10, 0));
    public static final Vote vote2 = new Vote(VOTE1_ID + 1, USER1_ID + 5, restaurant4,
            LocalDate.of(2022, 12, 25), LocalTime.of(12, 30));

    public static Vote getNew() {
        return new Vote(null, USER1_ID, restaurant1, LocalDate.of(2022, 12, 26), LocalTime.of(20, 50));
    }

    public static Vote getUpdated() {
        return new Vote(VOTE1_ID, USER1_ID + 2, restaurant2, LocalDate.of(2022, 12, 25), LocalTime.of(10, 0));
    }

    public static Vote getUpdatedNotPermitted() {
        return new Vote(VOTE1_ID, USER1_ID + 2, restaurant2, LocalDate.of(2022, 12, 25),
                THRESHOLD_TIME_FOR_CHANGING_VOTE.plus(2, ChronoUnit.HOURS));
    }
}
