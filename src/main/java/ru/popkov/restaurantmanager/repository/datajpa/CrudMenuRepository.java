package ru.popkov.restaurantmanager.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.popkov.restaurantmanager.model.Menu;

@Transactional(readOnly = true)
public interface CrudMenuRepository extends JpaRepository<Menu, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Menu m WHERE m.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT m FROM Menu m JOIN FETCH m.restaurant WHERE m.restaurant.id=:restaurantId")
    Menu getOfRestaurant(@Param("restaurantId") int restaurantId);
}
