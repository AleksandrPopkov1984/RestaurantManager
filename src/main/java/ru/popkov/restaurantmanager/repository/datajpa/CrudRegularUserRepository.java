package ru.popkov.restaurantmanager.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.popkov.restaurantmanager.model.RegularUser;

@Transactional(readOnly = true)
public interface CrudRegularUserRepository extends JpaRepository<RegularUser, Integer> {
}
