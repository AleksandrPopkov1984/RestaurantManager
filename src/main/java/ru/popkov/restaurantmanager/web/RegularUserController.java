package ru.popkov.restaurantmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.popkov.restaurantmanager.repository.MealRepository;
import ru.popkov.restaurantmanager.repository.RestaurantRepository;
import ru.popkov.restaurantmanager.to.MealTo;
import ru.popkov.restaurantmanager.to.RestaurantTo;
import ru.popkov.restaurantmanager.util.MealsUtil;
import ru.popkov.restaurantmanager.util.RestaurantsUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/users")
public class RegularUserController {

    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private MealRepository mealRepository;

    @GetMapping
    public String getRestaurants(Model model) {
        model.addAttribute("restaurants", getAll());
        return "restaurants";
    }

    @GetMapping("openFood")
    public String openFood(HttpServletRequest request, Model model) {
        model.addAttribute("meals", getOfRestaurant(getId(request)));
        return "meals";
    }

    public List<RestaurantTo> getAll() {
        return RestaurantsUtil.getTos(repository.getAll());
    }

    public List<MealTo> getOfRestaurant(int restaurantId) {
        return MealsUtil.getTos(mealRepository.getOfRestaurant(restaurantId));
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
