package ru.popkov.restaurantmanager.web.meal;

import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.service.MealService;
import ru.popkov.restaurantmanager.to.MealTo;
import ru.popkov.restaurantmanager.util.MealsUtil;
import ru.popkov.restaurantmanager.util.exception.NotFoundException;
import ru.popkov.restaurantmanager.web.AbstractControllerTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.popkov.restaurantmanager.MealTestData.*;
import static ru.popkov.restaurantmanager.MenuTestData.MENU1_ID;
import static ru.popkov.restaurantmanager.web.meal.MealAdminUIController.URL;

public class MealUIControllerTest extends AbstractControllerTest {

    @Autowired
    private MealService service;

    @Test
    void getOfMenu() throws Exception {
        perform(get(URL)
                .param("menuId", String.valueOf(MENU1_ID)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("meals"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/meals.jsp"))
                .andExpect(model().attribute("meals",
                        new AssertionMatcher<List<Meal>>() {
                            @Override
                            public void assertion(List<Meal> actual) throws AssertionError {
                                MEAL_MATCHER.assertMatch(actual, meal1, meal2);
                            }
                        }));
    }

    @Test
    void update() throws Exception {
        perform(get(URL + "/update")
                .param("id", String.valueOf(MEAL1_ID)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("mealForm"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/mealForm.jsp"))
                .andExpect(model().attribute("meal",
                        new AssertionMatcher<MealTo>() {
                            @Override
                            public void assertion(MealTo actual) throws AssertionError {
                                MEAL_TO_MATCHER.assertMatch(actual, mealTo);
                            }
                        }));
    }

    @Test
    void delete() throws Exception {
        perform(get(URL + "/delete")
                .param("id", String.valueOf(MEAL1_ID + 1))
                .param("menuId", String.valueOf(MENU1_ID)))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        assertThrows(NotFoundException.class, () -> service.get(MEAL1_ID + 1));
    }

    @Test
    void create() throws Exception {
        perform(get(URL + "/create")
                .param("menuId", String.valueOf(MENU1_ID + 2)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("mealForm"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/mealForm.jsp"))
                .andExpect(model().attribute("meal",
                        new AssertionMatcher<MealTo>() {
                            @Override
                            public void assertion(MealTo actual) throws AssertionError {
                                MEAL_TO_MATCHER.assertMatch(actual, newMealTo);
                            }
                        }));
    }

    @Test
    void updateOrCreate() throws Exception {
        perform(post(URL)
                .param("menuId", String.valueOf(MENU1_ID))
                .param("id", String.valueOf(MEAL1_ID))
                .param("name", "Chicken and Bacon")
                .param("price", String.valueOf(BigDecimal.valueOf(388))))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        MEAL_TO_MATCHER.assertMatch(MealsUtil.createTo(service.get(MEAL1_ID)), updatedMealTo);
    }
}
