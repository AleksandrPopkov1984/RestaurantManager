package ru.popkov.restaurantmanager.web.restaurant;

import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Test;
import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.web.AbstractControllerTest;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.popkov.restaurantmanager.RestaurantTestData.*;

public class RestaurantControllerTest extends AbstractControllerTest {

    @Test
    void getRestaurants() throws Exception {
        perform(get("/user/restaurants"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("restaurants"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/restaurants.jsp"))
                .andExpect(model().attribute("restaurants",
                        new AssertionMatcher<List<Restaurant>>() {
                            @Override
                            public void assertion(List<Restaurant> actual) throws AssertionError {
                                RESTAURANT_MATCHER.assertMatch(actual, restaurants);
                            }
                        }));
    }
}
