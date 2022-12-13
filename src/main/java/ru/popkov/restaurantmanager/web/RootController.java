package ru.popkov.restaurantmanager.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

    private static final Logger log = LoggerFactory.getLogger(RootController.class);

    @GetMapping("/")
    public String root() {
        log.info("root");
        return "index";
    }

    @PostMapping("/users")
    public String redirectToUsers(HttpServletRequest request) {
        log.info("redirect to Users");
        return "redirect:" + request.getParameter("userType");
    }
}
