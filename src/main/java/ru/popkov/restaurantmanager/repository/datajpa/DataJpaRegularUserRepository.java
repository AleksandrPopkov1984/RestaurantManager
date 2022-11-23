package ru.popkov.restaurantmanager.repository.datajpa;

import org.springframework.stereotype.Repository;
import ru.popkov.restaurantmanager.model.RegularUser;
import ru.popkov.restaurantmanager.repository.RegularUserRepository;

import java.util.List;

@Repository
public class DataJpaRegularUserRepository implements RegularUserRepository {

    private final CrudRegularUserRepository crudRegularUserRepository;

    public DataJpaRegularUserRepository(CrudRegularUserRepository crudRegularUserRepository) {
        this.crudRegularUserRepository = crudRegularUserRepository;
    }

    @Override
    public RegularUser save(RegularUser regularUser) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public RegularUser get(int id) {
        return null;
    }

    @Override
    public List<RegularUser> getAll() {
        return null;
    }
}
