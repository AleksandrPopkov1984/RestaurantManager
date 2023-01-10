package ru.popkov.restaurantmanager.util;

import ru.popkov.restaurantmanager.model.Vote;
import ru.popkov.restaurantmanager.to.VoteTo;

public class VoteUtil {

    public VoteUtil() {
    }

    public static VoteTo createTo(Vote vote, String status) {
        return new VoteTo(vote.getId(), vote.getUserId(), vote.getRestaurant(), vote.getDate(), vote.getTime(), status);
    }
}
