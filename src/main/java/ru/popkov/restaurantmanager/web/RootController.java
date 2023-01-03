package ru.popkov.restaurantmanager.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.popkov.restaurantmanager.model.Role;
import ru.popkov.restaurantmanager.model.User;
import ru.popkov.restaurantmanager.service.UserService;

import java.util.Objects;

@Controller
public class RootController {

    private static final Logger log = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String root() {
        int userId = Objects.requireNonNull(SecurityUtil.safeGet()).getId();
        User authorizedUser = service.get(userId);
        boolean hasAdminRole = authorizedUser.getRoles().contains(Role.ADMIN);
        if (hasAdminRole) {
            log.info("admin root");
            return "redirect:admin";
        } else {
            log.info("user root");
            return "redirect:user/restaurants";
        }
    }

    @GetMapping("/login")
    public String login() {
        log.info("login");
        return "login";
    }
}
