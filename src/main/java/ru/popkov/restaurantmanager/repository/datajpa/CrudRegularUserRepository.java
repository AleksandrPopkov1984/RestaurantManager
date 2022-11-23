package ru.popkov.restaurantmanager.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.popkov.restaurantmanager.model.RegularUser;

@Transactional(readOnly = true)
public interface CrudRegularUserRepository extends JpaRepository<RegularUser, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM RegularUser ru WHERE ru.id=:id")
    int delete(@Param("id") int id);

    RegularUser getByEmail(String email);
}
