package ru.popkov.restaurantmanager.web.meal;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.to.MealTo;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = MealAdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealAdminRestController extends AbstractMealController {

    public static final String REST_URL = "/rest/admin/restaurants/menus/meals";

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

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        super.delete(id);
    }

    @PostMapping(value = "/{menuId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createWithLocation(@RequestBody Meal meal, @PathVariable int menuId) {
        Meal created = super.create(meal, menuId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath().path(REST_URL + "/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Meal meal, @PathVariable int id) {
        super.update(meal, id);
    }
}
