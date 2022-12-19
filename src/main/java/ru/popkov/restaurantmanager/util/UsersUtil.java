package ru.popkov.restaurantmanager.util;

import ru.popkov.restaurantmanager.model.Role;
import ru.popkov.restaurantmanager.model.User;
import ru.popkov.restaurantmanager.to.UserToWithFullData;
import ru.popkov.restaurantmanager.to.UserTo;

import java.util.List;

public class UsersUtil {

    private UsersUtil() {
    }

    public static List<UserToWithFullData> getTos(List<User> users) {
        return users.stream()
                .map(UsersUtil::createToFullData)
                .toList();
    }

    public static UserToWithFullData createToFullData(User user) {
        return new UserToWithFullData(user.getId(), user.getSurname(), user.getName(), user.getEmail(), user.getPassword(), user.isEnabled(),
                user.getRegistered(), user.getRoles());
    }

    public static UserTo createTo(User user) {
        return new UserTo(user.getId(), user.getSurname(), user.getName(), user.getEmail(), user.getPassword());
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setSurname(userTo.getSurname());
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail());
        user.setPassword(userTo.getPassword());
        return user;
    }

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getSurname(), userTo.getName(), userTo.getEmail().toLowerCase(),
                userTo.getPassword(), Role.USER);
    }
}

