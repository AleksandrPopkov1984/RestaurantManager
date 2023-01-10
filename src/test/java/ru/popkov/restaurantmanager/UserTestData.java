package ru.popkov.restaurantmanager;

import ru.popkov.restaurantmanager.model.Role;
import ru.popkov.restaurantmanager.model.User;
import ru.popkov.restaurantmanager.to.UserTo;
import ru.popkov.restaurantmanager.to.UserToWithFullData;
import ru.popkov.restaurantmanager.web.json.JsonUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static ru.popkov.restaurantmanager.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {

    public static final MatcherFactory.Matcher<User> USER_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(User.class, "registered");
    public static final MatcherFactory.Matcher<UserTo> USER_TO_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(UserTo.class, "");
    public static final MatcherFactory.Matcher<UserToWithFullData> USER_TO_WITH_FULL_DATA_MATCHER =
            MatcherFactory.usingIgnoringFieldsComparator(UserToWithFullData.class, "registered");

    public static final int NOT_FOUND = 10;
    public static final int USER1_ID = START_SEQ;

    public static final User user1 = new User(USER1_ID, "Vasiljev", "Igor", "i_vasiljev@gmail.com", "admin", Role.ADMIN);
    public static final User user2 = new User(USER1_ID + 1, "Nikolaev", "Andrej", "a_nikolaev@gmail.com", "admin", Role.ADMIN);
    public static final User user3 = new User(USER1_ID + 2, "Anisimov", "Sergej", "s_anisimov@gmail.com", "password", Role.USER);
    public static final User user4 = new User(USER1_ID + 3, "Borodina", "Olga", "o_borodina@gmail.com", "password", Role.USER);
    public static final User user5 = new User(USER1_ID + 4, "Kolesnikov", "Dmitry", "d_kolesnikov@gmail.com", "password", Role.USER);
    public static final User user6 = new User(USER1_ID + 5, "Anishenko", "Irina", "i_anishenko@gmail.com", "password", Role.USER);
    public static final User user7 = new User(USER1_ID + 6, "Solomatin", "Aleksandr", "a_solomatin@gmail.com", "password", Role.USER);

    public static final User admin = new User(USER1_ID, "Vasiljev", "Igor", "i_vasiljev@gmail.com", "admin", Role.ADMIN, Role.USER);
    public static final User user = new User(USER1_ID + 2, "Anisimov", "Sergej", "s_anisimov@gmail.com", "password", Role.USER);
    public static final User userWithoutVote = new User(USER1_ID + 6, "Solomatin", "Aleksandr", "a_solomatin@gmail.com", "password", Role.USER);

    public static final List<User> users = List.of(user1, user2, user3, user4, user5, user6, user7);

    public static final UserToWithFullData userToWithFullData1 = new UserToWithFullData(USER1_ID, "Vasiljev", "Igor",
            "i_vasiljev@gmail.com", "admin", true, null, new HashSet<>(Arrays.asList(Role.ADMIN)));
    public static final UserToWithFullData userToWithFullData2 = new UserToWithFullData(USER1_ID + 1, "Nikolaev", "Andrej",
            "a_nikolaev@gmail.com", "admin", true, null, new HashSet<>(List.of(Role.ADMIN)));
    public static final UserToWithFullData userToWithFullData3 = new UserToWithFullData(USER1_ID + 2, "Anisimov", "Sergej",
            "s_anisimov@gmail.com", "password", true, null, new HashSet<>(List.of(Role.USER)));
    public static final UserToWithFullData userToWithFullData4 = new UserToWithFullData(USER1_ID + 3, "Borodina", "Olga",
            "o_borodina@gmail.com", "password", true, null, new HashSet<>(List.of(Role.USER)));
    public static final UserToWithFullData userToWithFullData5 = new UserToWithFullData(USER1_ID + 4, "Kolesnikov", "Dmitry",
            "d_kolesnikov@gmail.com", "password", true, null, new HashSet<>(List.of(Role.USER)));
    public static final UserToWithFullData userToWithFullData6 = new UserToWithFullData(USER1_ID + 5, "Anishenko", "Irina",
            "i_anishenko@gmail.com", "password", true, null, new HashSet<>(List.of(Role.USER)));
    public static final UserToWithFullData userToWithFullData7 = new UserToWithFullData(USER1_ID + 6, "Solomatin", "Aleksandr",
            "a_solomatin@gmail.com", "password", true, null, new HashSet<>(List.of(Role.USER)));

    public static final List<UserToWithFullData> usersToWithFullData = List.of(userToWithFullData1, userToWithFullData2,
            userToWithFullData3, userToWithFullData4, userToWithFullData5, userToWithFullData6, userToWithFullData7);

    public static final UserTo newUserTo = new UserTo(null, "", "", "", "");
    public static final UserTo userTo = new UserTo(USER1_ID, "Vasiljev", "Igor", "i_vasiljev@gmail.com", "admin");
    public static final UserTo userToFromUser = new UserTo(USER1_ID + 2, "Anisimov", "Sergej", "s_anisimov@gmail.com", "password");
    public static final UserTo updatedUserTo = new UserTo(USER1_ID + 6, "Fedorov", "Petr", "p.fedorov@gmail.com", "password");

    public static User getNew() {
        return new User(null, "Sviridov", "Ivan", "i.sviridov@Gmail.com", "password");
    }

    public static User getUpdated() {
        return new User(USER1_ID, "Fedorov", "Petr", "p.fedorov@gmail.com", "password");
    }

    public static String jsonWithPassword(User user, String passw) {
        return JsonUtil.writeAdditionProps(user, "password", passw);
    }
}
