package ru.popkov.restaurantmanager.web.vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.model.Vote;
import ru.popkov.restaurantmanager.service.RestaurantService;
import ru.popkov.restaurantmanager.service.VoteService;
import ru.popkov.restaurantmanager.to.VoteTo;
import ru.popkov.restaurantmanager.util.VoteUtil;

import java.time.LocalDate;
import java.time.LocalTime;

public class AbstractVoteController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService voteService;

    @Autowired
    private RestaurantService restaurantService;

    public Vote get(int id) {
        log.info("get {}", id);
        return voteService.get(id);
    }

    public VoteTo getTo(int id, String status) {
        log.info("get {}", id);
        return VoteUtil.createTo(voteService.get(id), status);
    }

    public Vote create(int restaurantId, int userId) {
        log.info("create vote for restaurant {}", restaurantId);
        Vote vote = getNew(restaurantId, userId);
        return voteService.create(vote);
    }

    public VoteTo createTo(int restaurantId, int userId) {
        log.info("create vote for restaurant {}", restaurantId);
        Vote vote = getNew(restaurantId, userId);
        return VoteUtil.createTo(voteService.create(vote), "created");
    }

    public boolean update(int id, int restaurantId, int userId) {
        log.info("update vote {} for restaurant {}", id, restaurantId);
        Vote vote = getOfUserAndDate(userId);
        vote.setRestaurant(restaurantService.get(restaurantId));
        return voteService.update(vote);
    }

    public Vote getNew(int restaurantId, int userId) {
        Restaurant restaurant = restaurantService.get(restaurantId);
        return new Vote(null, userId, restaurant, LocalDate.now(), LocalTime.now());
    }

    public Vote getOfUserAndDate(int userId) {
        log.info("get vote for user {}", userId);
        return voteService.getOfUserAndDate(userId, LocalDate.now());
    }
}
