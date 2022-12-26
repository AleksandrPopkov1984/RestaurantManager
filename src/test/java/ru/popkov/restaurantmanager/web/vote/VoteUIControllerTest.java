package ru.popkov.restaurantmanager.web.vote;

import org.junit.jupiter.api.Test;
import ru.popkov.restaurantmanager.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.popkov.restaurantmanager.RestaurantTestData.RESTAURANT1_ID;
import static ru.popkov.restaurantmanager.web.vote.VoteUIController.URL;

class VoteUIControllerTest extends AbstractControllerTest {

    @Test
    void notUpdate() throws Exception {
        perform(get(URL)
                .param("restaurantId", String.valueOf(RESTAURANT1_ID)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("vote"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/vote.jsp"));
    }
}