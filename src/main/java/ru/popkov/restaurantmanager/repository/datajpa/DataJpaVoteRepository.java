package ru.popkov.restaurantmanager.repository.datajpa;

import org.springframework.stereotype.Repository;
import ru.popkov.restaurantmanager.model.Vote;
import ru.popkov.restaurantmanager.repository.VoteRepository;

import java.time.LocalDate;

@Repository
public class DataJpaVoteRepository implements VoteRepository {

    private final CrudVoteRepository crudVoteRepository;

    public DataJpaVoteRepository(CrudVoteRepository crudVoteRepository) {
        this.crudVoteRepository = crudVoteRepository;
    }

    @Override
    public Vote save(Vote vote) {
        return crudVoteRepository.save(vote);
    }

    @Override
    public Vote get(int id) {
        return crudVoteRepository.findById(id).orElse(null);
    }

    @Override
    public Vote getOfUserAndDate(int userId, LocalDate date) {
        return crudVoteRepository.getOfUserAndDate(userId, date);
    }

    @Override
    public int getCountOfRestaurant(int restaurantId) {
        return crudVoteRepository.getCountOfRestaurant(restaurantId);
    }
}
