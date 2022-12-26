package ru.popkov.restaurantmanager.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.popkov.restaurantmanager.model.Vote;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT COUNT(v.id) FROM Vote v WHERE v.restaurantId=:restaurantId")
    int getCountOfRestaurant(@Param("restaurantId") int restaurantId);
}
