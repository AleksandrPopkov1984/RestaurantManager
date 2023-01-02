package ru.popkov.restaurantmanager.web.meal;

import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Test;
import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.web.AbstractControllerTest;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.popkov.restaurantmanager.RestaurantTestData.RESTAURANT1_ID;
import static ru.popkov.restaurantmanager.MealTestData.*;
import static ru.popkov.restaurantmanager.TestUtil.userAuth;
import static ru.popkov.restaurantmanager.UserTestData.user;
import static ru.popkov.restaurantmanager.web.meal.MealUserUIController.URL;

class MealUserUIControllerTest extends AbstractControllerTest {

    @Test
    void getByRestaurantId() throws Exception {
        perform(get(URL)
                .param("restaurantId", String.valueOf(RESTAURANT1_ID))
                .with(userAuth(user)))
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

}