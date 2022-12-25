package ru.popkov.restaurantmanager.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.popkov.restaurantmanager.model.Meal;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Meal m WHERE m.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT m FROM Meal m JOIN FETCH m.menu WHERE m.menu.id=:menuId ORDER BY m.id")
    List<Meal> getOfMenu(@Param("menuId") int menuId);

    @Query(value = "SELECT * FROM meals m JOIN menus mu ON m.menu_id = mu.id JOIN restaurants r ON mu.restaurant_id = r.id " +
            "WHERE r.id = :restaurantId AND date = (SELECT MAX(date) FROM menus)", nativeQuery = true)
    List<Meal> getOfRestaurant(@Param("restaurantId") int restaurantId);
}
