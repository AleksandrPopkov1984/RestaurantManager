package ru.popkov.restaurantmanager.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.popkov.restaurantmanager.repository.UserRepository;
import ru.popkov.restaurantmanager.to.UserTo;
import ru.popkov.restaurantmanager.util.UsersUtil;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository repository;

    @GetMapping
    public String getRestaurants() {
        return "redirect: users/restaurants";
    }

    @PostMapping
    public String getAllUsers(Model model) {
        log.info("users");
        model.addAttribute("users", getAll());
        return "users";
    }

    public List<UserTo> getAll() {
        return UsersUtil.getTos(repository.getAll());
    }
}
