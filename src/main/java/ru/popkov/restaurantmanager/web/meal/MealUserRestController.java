package ru.popkov.restaurantmanager.web.meal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.popkov.restaurantmanager.to.MealTo;

import java.util.List;

@RestController
@RequestMapping(value = MealUserRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealUserRestController extends AbstractMealController {

    public static final String REST_URL = "/rest/user/restaurants/menus/meals";

    @Override
    @GetMapping("/{id}")
    public MealTo get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @GetMapping("/ofMenu")
    public List<MealTo> getOfMenu(@RequestParam int menuId) {
        return super.getOfMenu(menuId);
    }
}
