package ru.popkov.restaurantmanager.web.user;

import org.junit.jupiter.api.Test;
import ru.popkov.restaurantmanager.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.popkov.restaurantmanager.TestUtil.userAuth;
import static ru.popkov.restaurantmanager.UserTestData.user;
import static ru.popkov.restaurantmanager.web.user.ProfileUIController.URL;

class ProfileUIControllerTest extends AbstractControllerTest {

    @Test
    void register() throws Exception {
        perform(get(URL + "/register"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("profile"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/profile.jsp"));
    }

    @Test
    void profile() throws Exception {
        perform(get(URL)
                .with(userAuth(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("profile"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/profile.jsp"));
    }
}