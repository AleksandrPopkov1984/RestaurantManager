package ru.popkov.restaurantmanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @PostMapping("/users")
    public String redirect(HttpServletRequest request) {
        return "redirect:" + request.getParameter("userType");
    }
}
