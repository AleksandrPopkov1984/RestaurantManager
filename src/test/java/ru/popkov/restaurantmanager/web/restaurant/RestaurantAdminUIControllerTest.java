package ru.popkov.restaurantmanager.web.restaurant;

import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.Restaurant;
import ru.popkov.restaurantmanager.service.RestaurantService;
import ru.popkov.restaurantmanager.to.RestaurantTo;
import ru.popkov.restaurantmanager.util.RestaurantsUtil;
import ru.popkov.restaurantmanager.util.exception.NotFoundException;
import ru.popkov.restaurantmanager.web.AbstractControllerTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.popkov.restaurantmanager.RestaurantTestData.*;
import static ru.popkov.restaurantmanager.web.restaurant.RestaurantAdminUIController.URL;

public class RestaurantAdminUIControllerTest extends AbstractControllerTest {

    @Autowired
    private RestaurantService service;

    @Test
    void getRestaurants() throws Exception {
        perform(get(URL))
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

    @Test
    void delete() throws Exception {
        perform(get(URL + "/delete")
                .param("id", String.valueOf(RESTAURANT1_ID)))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(URL));

        assertThrows(NotFoundException.class, () -> service.get(RESTAURANT1_ID));
    }

    @Test
    void update() throws Exception {
        perform(get(URL + "/update")
                .param("id", String.valueOf(RESTAURANT1_ID)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("restaurantForm"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/restaurantForm.jsp"))
                .andExpect(model().attribute("restaurant",
                        new AssertionMatcher<RestaurantTo>() {
                            @Override
                            public void assertion(RestaurantTo actual) throws AssertionError {
                                RESTAURANT_TO_MATCHER.assertMatch(actual, restaurantTo);
                            }
                        }));
    }

    @Test
    void create() throws Exception {
        perform(get(URL + "/create"))
                .andDo(print())
                .andExpect(view().name("restaurantForm"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/restaurantForm.jsp"))
                .andExpect(model().attribute("restaurant",
                        new AssertionMatcher<RestaurantTo>() {
                            @Override
                            public void assertion(RestaurantTo actual) throws AssertionError {
                                RESTAURANT_TO_MATCHER.assertMatch(actual, newRestaurantTo);
                            }
                        }));
    }

    @Test
    void updateOrCreate() throws Exception {
        int id = updatedRestaurantTo.getId();
        perform(post(URL)
                .param("id", String.valueOf(RESTAURANT1_ID))
                .param("name", "Metropol Luxe"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        RESTAURANT_TO_MATCHER.assertMatch(RestaurantsUtil.createTo(service.get(id)), updatedRestaurantTo);
    }
}
