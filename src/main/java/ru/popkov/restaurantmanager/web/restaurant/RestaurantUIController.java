package ru.popkov.restaurantmanager.web.restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.popkov.restaurantmanager.model.Restaurant;

@Controller
@RequestMapping("/users/restaurants")
public class RestaurantUIController extends AbstractRestaurantController {

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("restaurants", super.getAll());
        return "restaurants";
    }

    @Override
    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Restaurant create(Restaurant restaurant) {
        return super.create(restaurant);
    }

    @Override
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(Restaurant restaurant, int id) {
        super.update(restaurant, restaurant.getId());
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        super.delete(id);
    }
}