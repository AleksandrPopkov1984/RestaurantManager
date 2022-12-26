package ru.popkov.restaurantmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.popkov.restaurantmanager.model.Vote;
import ru.popkov.restaurantmanager.repository.VoteRepository;

import java.time.LocalDate;
import java.time.LocalTime;

import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {

    private static final LocalTime THRESHOLD_TIME_FOR_CHANGING_VOTE = LocalTime.of(11, 0);

    private final VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public Vote create(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        return repository.save(vote);
    }

    public Vote get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public int getCountOfRestaurant(int restaurantId) {
        return repository.getCountOfRestaurant(restaurantId);
    }

    public Vote getOfUserAndDate(int userId, LocalDate date) {
        return repository.getOfUserAndDate(userId, date);
    }

    public boolean update(Vote vote) {
        if (vote.getTime().isAfter(THRESHOLD_TIME_FOR_CHANGING_VOTE)) {
            return false;
        } else {
            Assert.notNull(vote, "vote must not be null");
            checkNotFoundWithId(repository.save(vote), vote.id());
            return true;
        }
    }
}
