package ru.popkov.restaurantmanager.repository;

import ru.popkov.restaurantmanager.model.Vote;

import java.time.LocalDate;

public interface VoteRepository {

    Vote save(Vote vote);

    Vote get(int id);

    Vote getOfUserAndDate(int userId, LocalDate date);

    int getCountOfRestaurant(int restaurantId);
}
