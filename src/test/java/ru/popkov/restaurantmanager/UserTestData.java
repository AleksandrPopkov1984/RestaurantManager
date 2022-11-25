package ru.popkov.restaurantmanager;

import ru.popkov.restaurantmanager.model.RegularUser;

import java.util.List;

import static ru.popkov.restaurantmanager.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {

    public static final MatcherFactory.Matcher<RegularUser> USER_MATCHER = MatcherFactory.usingIgnoreFieldsComparator("registered");

    public static final int NOT_FOUND = 10;
    public static final int USER1_ID = START_SEQ + 2;

    public static final RegularUser user1 = new RegularUser(USER1_ID, "Sergej", "Anisimov", "s_anisimov@gmail.com", "password");
    public static final RegularUser user2 = new RegularUser(USER1_ID + 1, "Olga", "Borodina", "o_borodina@gmail.com", "password");
    public static final RegularUser user3 = new RegularUser(USER1_ID + 2, "Dmitry", "Kolesnikov", "d_kolesnikov@gmail.com", "password");
    public static final RegularUser user4 = new RegularUser(USER1_ID + 3, "Irina", "Anishenko", "i_anishenko@gmail.com", "password");
    public static final RegularUser user5 = new RegularUser(USER1_ID + 4, "Aleksandr", "Solomatin", "a_solomatin@gmail.com", "password");

    public static final List<RegularUser> users = List.of(user1, user2, user3, user4, user5);

    public static RegularUser getNew() {
        return new RegularUser(null, "Ivan", "Sviridov", "i.sviridov@Gmail.com", "password");
    }

    public static RegularUser getUpdated() {
        return new RegularUser(USER1_ID, "Petr", "Fedorov", "p.fedorov@gmail.com", "password");
    }
}
