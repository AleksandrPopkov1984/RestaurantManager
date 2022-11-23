package ru.popkov.restaurantmanager.repository;

import ru.popkov.restaurantmanager.model.RegularUser;

import java.util.List;

public interface RegularUserRepository {

    RegularUser save(RegularUser regularUser);

    boolean delete(int id);

    RegularUser get(int id);

    RegularUser getByEmail(String email);

    List<RegularUser> getAll();
}
