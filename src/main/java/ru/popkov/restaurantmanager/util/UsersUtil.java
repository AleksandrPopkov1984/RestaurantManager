package ru.popkov.restaurantmanager.util;

import ru.popkov.restaurantmanager.model.User;
import ru.popkov.restaurantmanager.to.UserTo;

import java.util.List;

public class UsersUtil {

    private UsersUtil() {
    }

    public static List<UserTo> getTos(List<User> restaurants) {
        return restaurants.stream()
                .map(UsersUtil::createTo)
                .toList();
    }

    public static UserTo createTo(User user) {
        return new UserTo(user.getId(), user.getSurname(), user.getName(), user.getEmail(), user.getPassword(), user.isEnabled(),
                user.getRegistered(), user.getRoles());
    }
}

