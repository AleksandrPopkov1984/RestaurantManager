package ru.popkov.restaurantmanager.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.User;
import ru.popkov.restaurantmanager.service.UserService;
import ru.popkov.restaurantmanager.to.UserToWithFullData;
import ru.popkov.restaurantmanager.to.UserTo;
import ru.popkov.restaurantmanager.util.UsersUtil;

import java.util.List;

import static ru.popkov.restaurantmanager.util.ValidationUtil.assureIdConsistent;
import static ru.popkov.restaurantmanager.util.ValidationUtil.checkNew;

public abstract class AbstractUserController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    public List<UserToWithFullData> getAll() {
        log.info("getAll");
        return UsersUtil.getTos(service.getAll());
    }

    public UserTo get(int id) {
        log.info("get {}", id);
        return UsersUtil.createTo(service.get(id));
    }

    public User create(User user) {
        log.info("create {}", user);
        checkNew(user);
        return service.create(user);
    }

    public void create(UserTo userTo) {
        log.info("create {}", userTo);
        checkNew(userTo);
        service.create(UsersUtil.createNewFromTo(userTo));
    }

    public void update(User user, int id) {
        log.info("update {} with id {}", user, id);
        assureIdConsistent(user, id);
        service.update(user);
    }

    public void update(UserTo userTo, int id) {
        log.info("update {} with id {}", userTo, id);
        assureIdConsistent(userTo, id);
        service.update(userTo);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void enable(int id, boolean enabled) {
        log.info(enabled ? "enable {}" : "disable {}", id);
        service.enable(id, enabled);
    }
}
