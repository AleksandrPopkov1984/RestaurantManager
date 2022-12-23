package ru.popkov.restaurantmanager.web.menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/restaurants/menus")
public class MenuAdminUIController extends AbstractMenuController {

    @GetMapping
    public String getOfRestaurant(@RequestParam int restaurantId, Model model) {
        model.addAttribute("menus", super.getOfRestaurant(restaurantId));
        return "menus";
    }
}
