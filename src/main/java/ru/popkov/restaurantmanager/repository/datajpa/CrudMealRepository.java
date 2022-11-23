package ru.popkov.restaurantmanager.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.popkov.restaurantmanager.model.Meal;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Query("SELECT m FROM Meal m JOIN FETCH m.restaurant WHERE m.restaurant.id=:restaurantId")
    List<Meal> getOfRestaurant(@Param("restaurantId") int restaurantId);
}
