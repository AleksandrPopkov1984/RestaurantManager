package ru.popkov.restaurantmanager.web.menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.popkov.restaurantmanager.model.Menu;
import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.to.MenuTo;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping(MenuAdminUIController.URL)
public class MenuAdminUIController extends AbstractMenuController {

    public static final String URL = "/admin/restaurants/menus";

    @GetMapping
    public String getOfRestaurant(@RequestParam int restaurantId, Model model) {
        model.addAttribute("menus", super.getOfRestaurant(restaurantId));
        model.addAttribute("restaurantId", restaurantId);
        return "menus";
    }

    @GetMapping("/delete")
    public String deleteMenu(@RequestParam int id, @RequestParam int restaurantId) {
        super.delete(id);
        return "redirect:" + URL + "?restaurantId=" + restaurantId;
    }

    @GetMapping("/create")
    public String createMenu(@RequestParam int restaurantId, Model model) {
        Restaurant restaurant = super.getRestaurant(restaurantId);
        model.addAttribute("menu", new MenuTo(null, LocalDate.now(), restaurant, null));
        return "menuForm";
    }

    @PostMapping
    public String createMenu(@Valid MenuTo menuTo, @RequestParam int restaurantId) {
        Restaurant restaurant = super.getRestaurant(restaurantId);
        menuTo.setRestaurant(restaurant);
        if (menuTo.isNew()) {
            Menu menu = super.create(menuTo, restaurantId);
            super.createNewMeal(menu.id());
        }
        return "redirect:" + URL + "?restaurantId=" + restaurantId;
    }
}
