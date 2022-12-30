package ru.popkov.restaurantmanager.web.restaurant;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.popkov.restaurantmanager.model.Restaurant;

@Controller
@RequestMapping(RestaurantUserUIController.URL)
public class RestaurantUserUIController extends AbstractRestaurantController {

    public static final String URL = "/user/restaurants";

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("restaurants", super.getAll());
        return "restaurants";
    }
}
