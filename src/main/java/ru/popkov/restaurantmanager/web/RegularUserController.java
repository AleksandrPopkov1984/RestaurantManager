package ru.popkov.restaurantmanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class RegularUserController {

    @GetMapping
    public String getRestaurants() {
        return "redirect: users/restaurants";
    }
}
