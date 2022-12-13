package ru.popkov.restaurantmanager;

import ru.popkov.restaurantmanager.model.User;

import java.util.List;

import static ru.popkov.restaurantmanager.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {

    public static final MatcherFactory.Matcher<User> USER_MATCHER = MatcherFactory.usingIgnoreFieldsComparator("registered");

    public static final int NOT_FOUND = 10;
    public static final int USER1_ID = START_SEQ;

    public static final User user1 = new User(USER1_ID, "Igor", "Vasiljev", "i_vasiljev@gmail.com", "1234");
    public static final User user2 = new User(USER1_ID + 1, "Andrej", "Nikolaev", "a_nikolaev@gmail.com", "4321");
    public static final User user3 = new User(USER1_ID + 2, "Sergej", "Anisimov", "s_anisimov@gmail.com", "password");
    public static final User user4 = new User(USER1_ID + 3, "Olga", "Borodina", "o_borodina@gmail.com", "password");
    public static final User user5 = new User(USER1_ID + 4, "Dmitry", "Kolesnikov", "d_kolesnikov@gmail.com", "password");
    public static final User user6 = new User(USER1_ID + 5, "Irina", "Anishenko", "i_anishenko@gmail.com", "password");
    public static final User user7 = new User(USER1_ID + 6, "Aleksandr", "Solomatin", "a_solomatin@gmail.com", "password");

    public static final List<User> users = List.of(user1, user2, user3, user4, user5, user6, user7);

    public static User getNew() {
        return new User(null, "Ivan", "Sviridov", "i.sviridov@Gmail.com", "password");
    }

    public static User getUpdated() {
        return new User(USER1_ID, "Petr", "Fedorov", "p.fedorov@gmail.com", "password");
    }
}
