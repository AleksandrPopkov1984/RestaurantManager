package ru.popkov.restaurantmanager.model;

import ru.popkov.restaurantmanager.util.Util;

import java.time.LocalTime;
import java.util.Date;

public class RegularUser extends AbstractUser {

    private static final LocalTime DEADLINE_TIME_FOR_CHANGE_VOTE = LocalTime.of(18, 0);

    public RegularUser() {
    }

    public RegularUser(Integer id, String surname, String name, String email, String password, boolean enabled, Date registered) {
        super(id, surname, name, email, password, enabled, registered);
    }

    public RegularUser(Integer id, String surname, String name, String email, String password, Date registered) {
        this(id, surname, name, email, password, true, registered);
    }

    public int vote(Integer restaurantId) {
        if (Util.isBetweenHalfOpen(LocalTime.now(), LocalTime.of(0, 0), DEADLINE_TIME_FOR_CHANGE_VOTE)) {
            return restaurantId;
        } else {
            return 0;
        }
    }
}
