package ru.popkov.restaurantmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.popkov.restaurantmanager.repository.RestaurantRepository;
import ru.popkov.restaurantmanager.to.RestaurantTo;
import ru.popkov.restaurantmanager.util.RestaurantsUtil;

import java.util.List;

@Controller
@RequestMapping("/users")
public class RegularUserController {

    @Autowired
    protected RestaurantRepository repository;

    @GetMapping
    public String getRestaurants(Model model) {
        model.addAttribute("restaurants", getAll());
        return "restaurants";
    }

    public List<RestaurantTo> getAll() {
        return RestaurantsUtil.getTos(repository.getAll());
    }
}
