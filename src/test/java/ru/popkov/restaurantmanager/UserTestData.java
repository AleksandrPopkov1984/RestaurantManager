package ru.popkov.restaurantmanager;

import ru.popkov.restaurantmanager.model.Role;
import ru.popkov.restaurantmanager.model.User;

import java.util.List;

import static ru.popkov.restaurantmanager.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {

    public static final MatcherFactory.Matcher<User> USER_MATCHER = MatcherFactory.usingIgnoreFieldsComparator("registered");

    public static final int NOT_FOUND = 10;
    public static final int USER1_ID = START_SEQ;

    public static final User user1 = new User(USER1_ID, "Vasiljev", "Igor", "i_vasiljev@gmail.com", "1234", Role.ADMIN, Role.USER);
    public static final User user2 = new User(USER1_ID + 1, "Nikolaev", "Andrej", "a_nikolaev@gmail.com", "4321", Role.ADMIN);
    public static final User user3 = new User(USER1_ID + 2, "Anisimov", "Sergej", "s_anisimov@gmail.com", "password", Role.USER);
    public static final User user4 = new User(USER1_ID + 3, "Borodina", "Olga", "o_borodina@gmail.com", "password", Role.USER);
    public static final User user5 = new User(USER1_ID + 4, "Kolesnikov", "Dmitry", "d_kolesnikov@gmail.com", "password", Role.USER);
    public static final User user6 = new User(USER1_ID + 5, "Anishenko", "Irina", "i_anishenko@gmail.com", "password", Role.USER);
    public static final User user7 = new User(USER1_ID + 6, "Solomatin", "Aleksandr", "a_solomatin@gmail.com", "password", Role.USER);

    public static final List<User> users = List.of(user1, user2, user3, user4, user5, user6, user7);

    public static User getNew() {
        return new User(null, "Sviridov", "Ivan", "i.sviridov@Gmail.com", "password");
    }

    public static User getUpdated() {
        return new User(USER1_ID, "Fedorov", "Petr", "p.fedorov@gmail.com", "password");
    }
}
