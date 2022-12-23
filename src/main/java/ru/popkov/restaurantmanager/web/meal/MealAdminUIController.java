package ru.popkov.restaurantmanager.web.meal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/restaurants/menus/menu")
public class MealAdminUIController extends AbstractMealController {

    @GetMapping
    public String getOfMenu(@RequestParam int menuId, Model model) {
        model.addAttribute("meals", super.getOfMenu(menuId));
        return "meals";
    }
}
