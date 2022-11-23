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
        return crudRegularUserRepository.save(regularUser);
    }

    @Override
    public boolean delete(int id) {
        return crudRegularUserRepository.delete(id) != 0;
    }

    @Override
    public RegularUser get(int id) {
        return crudRegularUserRepository.findById(id).orElse(null);
    }

    @Override
    public RegularUser getByEmail(String email) {
        return crudRegularUserRepository.getByEmail(email);
    }

    @Override
    public List<RegularUser> getAll() {
        return crudRegularUserRepository.findAll();
    }
}
