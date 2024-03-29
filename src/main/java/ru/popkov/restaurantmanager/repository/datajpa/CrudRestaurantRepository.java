package ru.popkov.restaurantmanager.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.popkov.restaurantmanager.model.Restaurant;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.votes ORDER BY r.id ASC")
    List<Restaurant> findAll();

    @Query("SELECT r FROM Restaurant r LEFT JOIN r.menus LEFT JOIN FETCH r.votes WHERE r.id=:id")
    Restaurant findById(@Param("id") int id);
}
