package ru.popkov.restaurantmanager.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RootController {

    private static final Logger log = LoggerFactory.getLogger(RootController.class);

    @GetMapping("/")
    public String root() {
        log.info("root");
        return "index";
    }

    @PostMapping("/start")
    public String redirectToUsers(@RequestParam String userType) {
        log.info("redirect to users");
        return "redirect:" + userType;
    }

    @PostMapping("/admins")
    public String redirectToAdmins(@RequestParam String userType) {
        log.info("redirect to admins");
        return "redirect:" + userType;
    }
}
