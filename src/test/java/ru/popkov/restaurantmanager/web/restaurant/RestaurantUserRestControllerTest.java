package ru.popkov.restaurantmanager.web.restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.popkov.restaurantmanager.service.RestaurantService;
import ru.popkov.restaurantmanager.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static ru.popkov.restaurantmanager.web.restaurant.RestaurantUserRestController.REST_URL;
import static ru.popkov.restaurantmanager.RestaurantTestData.*;

class RestaurantUserRestControllerTest extends AbstractControllerTest {

    @Autowired
    private RestaurantService service;

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(RESTAURANT_TO_MATCHER.contentJson(restaurantsTo));
    }

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "/" + RESTAURANT1_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(RESTAURANT_TO_MATCHER.contentJson(restaurantTo1));
    }

    @Test
    void getNotFound() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "/" + NOT_FOUND))
                .andDo(print())
                .andExpect(view().name("exception/exception"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/exception/exception.jsp"));
    }
}