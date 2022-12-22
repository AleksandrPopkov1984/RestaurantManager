package ru.popkov.restaurantmanager.web.restaurant;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.popkov.restaurantmanager.model.Restaurant;

@Controller
@RequestMapping("/user/restaurants")
public class RestaurantUserUIController extends AbstractRestaurantController {

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("restaurants", super.getAll());
        return "restaurants";
    }
}
