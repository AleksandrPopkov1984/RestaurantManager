package ru.popkov.restaurantmanager.web;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.popkov.restaurantmanager.TestUtil.userAuth;
import static ru.popkov.restaurantmanager.UserTestData.admin;

class AdminControllerTest extends AbstractControllerTest {

    @Test
    void getAdminPage() throws Exception {
        perform(get("/admin")
                .with(userAuth(admin)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("admins"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/admins.jsp"));
    }
}