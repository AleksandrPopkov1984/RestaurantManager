package ru.popkov.restaurantmanager.web;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.popkov.restaurantmanager.TestUtil.userAuth;
import static ru.popkov.restaurantmanager.UserTestData.admin;
import static ru.popkov.restaurantmanager.UserTestData.user;

public class RootControllerTest extends AbstractControllerTest {

    @Test
    void getAdminStartPage() throws Exception {
        perform(get("/")
                .with(userAuth(admin)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("admins"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/admins.jsp"));
    }

    @Test
    void getUserStartPage() throws Exception {
        perform(get("/")
                .with(userAuth(user)))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:user/restaurants"))
                .andExpect(redirectedUrl("user/restaurants"));
    }

    @Test
    void login() throws Exception {
        perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/login.jsp"));
    }
}
