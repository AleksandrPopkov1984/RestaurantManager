package ru.popkov.restaurantmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.popkov.restaurantmanager.model.Vote;
import ru.popkov.restaurantmanager.repository.VoteRepository;

import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {

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
}
