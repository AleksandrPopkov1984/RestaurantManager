package ru.popkov.restaurantmanager.web.restaurant;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.popkov.restaurantmanager.to.RestaurantTo;

import javax.validation.Valid;

@Controller
@RequestMapping(RestaurantAdminUIController.URL)
public class RestaurantAdminUIController extends AbstractRestaurantController {

    public static final String URL = "/admin/restaurants";

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("restaurants", super.getAll());
        return "restaurants";
    }

    @GetMapping("/delete")
    public String deleteRestaurant(@RequestParam int id) {
        super.delete(id);
        return "redirect:" + URL;
    }

    @GetMapping("/update")
    public String updateRestaurant(@RequestParam int id, Model model) {
        model.addAttribute("restaurant", super.get(id));
        return "restaurantForm";
    }

    @GetMapping("/create")
    public String createRestaurant(Model model) {
        model.addAttribute("restaurant", new RestaurantTo(null, ""));
        return "restaurantForm";
    }

    @PostMapping
    public String updateOrCreate(@Valid RestaurantTo restaurantTo) {
        if (restaurantTo.isNew()) {
            super.create(restaurantTo);
        } else {
            super.update(restaurantTo, restaurantTo.getId());
        }
        return "redirect:" + URL;
    }
}
