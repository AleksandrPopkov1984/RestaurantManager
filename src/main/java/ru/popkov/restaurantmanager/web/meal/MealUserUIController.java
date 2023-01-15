package ru.popkov.restaurantmanager.web.meal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping(MealUserUIController.URL)
public class MealUserUIController extends AbstractMealController {

    public static final String URL = "/user/meals";

    @GetMapping
    public String getByRestaurantId(@RequestParam int restaurantId, Model model) {
        model.addAttribute("meals", super.getActualMenuOfRestaurant(restaurantId));
        return "meals";
    }
}
