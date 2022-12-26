package ru.popkov.restaurantmanager.repository;

import ru.popkov.restaurantmanager.model.Vote;

public interface VoteRepository {

    Vote save(Vote vote);

    Vote get(int id);

    int getCountOfRestaurant(int restaurantId);
}
