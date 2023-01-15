package ru.popkov.restaurantmanager.web.menu;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.popkov.restaurantmanager.to.MenuTo;

import java.util.List;

@RestController
@RequestMapping(value = MenuAdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuAdminRestController extends AbstractMenuController {

    public static final String REST_URL = "/rest/admin/restaurants/menus";

    @Override
    @GetMapping
    public List<MenuTo> getOfRestaurant(@RequestParam int restaurantId) {
        return super.getOfRestaurant(restaurantId);
    }

    @Override
    @GetMapping("/{id}")
    public MenuTo get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        super.delete(id);
    }
}
