package ru.popkov.restaurantmanager.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.popkov.restaurantmanager.repository.MealRepository;
import ru.popkov.restaurantmanager.util.MealsUtil;

@Controller
@RequestMapping("/users/meals")
public class MealController {

    private static final Logger log = LoggerFactory.getLogger(MealController.class);

    @Autowired
    private MealRepository mealRepository;

    @GetMapping
    public String getByRestaurantId(@RequestParam int restaurantId, Model model) {
        log.info("get meals for restaurant {}", restaurantId);
        model.addAttribute("meals", MealsUtil.getTos(mealRepository.getOfMenu(restaurantId)));
        return "meals";
    }
}
