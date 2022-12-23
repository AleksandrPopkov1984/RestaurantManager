package ru.popkov.restaurantmanager.web.meal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.popkov.restaurantmanager.model.Menu;
import ru.popkov.restaurantmanager.to.MealTo;

import javax.validation.Valid;
import java.math.BigDecimal;

@Controller
@RequestMapping(MealAdminUIController.URL)
public class MealAdminUIController extends AbstractMealController {

    public static final String URL = "/admin/restaurants/menus/menu";

    @GetMapping
    public String getOfMenu(@RequestParam int menuId, Model model) {
        model.addAttribute("meals", super.getOfMenu(menuId));
        return "meals";
    }

    @GetMapping("/update")
    public String updateMeal(@RequestParam int id, Model model) {
        model.addAttribute("meal", super.get(id));
        return "mealForm";
    }

    @GetMapping("/delete")
    public String deleteMeal(@RequestParam int id, @RequestParam int menuId) {
        super.delete(id);
        return "redirect:" + URL + "?menuId=" + menuId;
    }

    @GetMapping("/create")
    public String createMeal(Model model, @RequestParam int menuId) {
        Menu menu = super.getMenu(menuId);
        model.addAttribute("meal", new MealTo(null, "", BigDecimal.valueOf(100), menu));
        return "mealForm";
    }

    @PostMapping
    public String updateOrCreate(@Valid MealTo mealTo, @RequestParam int menuId) {
        Menu menu = super.getMenu(menuId);
        mealTo.setMenu(menu);
        if (mealTo.isNew()) {
            super.create(mealTo, menuId);
        } else {
            super.update(mealTo, menuId);
        }
        return "redirect:" + URL + "?menuId=" + menuId;
    }
}
