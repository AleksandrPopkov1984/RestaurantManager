package ru.popkov.restaurantmanager.web.restaurant;

import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Test;
import ru.popkov.restaurantmanager.to.RestaurantTo;
import ru.popkov.restaurantmanager.web.AbstractControllerTest;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.popkov.restaurantmanager.TestUtil.userAuth;
import static ru.popkov.restaurantmanager.UserTestData.user;
import static ru.popkov.restaurantmanager.web.restaurant.RestaurantUserUIController.URL;
import static ru.popkov.restaurantmanager.RestaurantTestData.*;

class RestaurantUserUIControllerTest extends AbstractControllerTest {

    @Test
    void getAll() throws Exception {
        perform(get(URL)
                .with(userAuth(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("restaurants"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/restaurants.jsp"))
                .andExpect(model().attribute("restaurants",
                        new AssertionMatcher<List<RestaurantTo>>() {
                            @Override
                            public void assertion(List<RestaurantTo> actual) throws AssertionError {
                                RESTAURANT_TO_MATCHER.assertMatch(actual, restaurantsTo);
                            }
                        }));
    }
}