package ru.popkov.restaurantmanager.web.user;

import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import ru.popkov.restaurantmanager.model.User;
import ru.popkov.restaurantmanager.service.UserService;
import ru.popkov.restaurantmanager.to.UserTo;
import ru.popkov.restaurantmanager.util.UsersUtil;
import ru.popkov.restaurantmanager.util.exception.NotFoundException;
import ru.popkov.restaurantmanager.web.AbstractControllerTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.popkov.restaurantmanager.UserTestData.*;
import static ru.popkov.restaurantmanager.web.user.UserUIController.URL;

public class UserUIControllerTest extends AbstractControllerTest {

    @Autowired
    private UserService service;

    @Test
    void getAll() throws Exception {
        perform(get("/" + URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("users"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/users.jsp"))
                .andExpect(model().attribute("users",
                        new AssertionMatcher<List<User>>() {
                            @Override
                            public void assertion(List<User> actual) throws AssertionError {
                                USER_MATCHER.assertMatch(actual, users);
                            }
                        }));
    }

    @Test
    void create() throws Exception {
        perform(get("/" + URL + "/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("userForm"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/userForm.jsp"))
                .andExpect(model().attribute("user",
                        new AssertionMatcher<UserTo>() {
                            @Override
                            public void assertion(UserTo actual) throws AssertionError {
                                USER_TO_MATCHER.assertMatch(actual, newUserTo);
                            }
                        }));
    }

    @Test
    void update() throws Exception {
        perform(get("/" + URL + "/update")
                .param("id", String.valueOf(USER1_ID)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("userForm"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/userForm.jsp"))
                .andExpect(model().attribute("user",
                        new AssertionMatcher<UserTo>() {
                            @Override
                            public void assertion(UserTo actual) throws AssertionError {
                                USER_TO_MATCHER.assertMatch(actual, userTo);
                            }
                        }));
    }

    @Test
    void delete() throws Exception {
        perform(get("/" + URL + "/delete")
                .param("id", String.valueOf(USER1_ID + 2)))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        assertThrows(NotFoundException.class, () -> service.get(USER1_ID + 2));
    }

    @Test
    void createOrUpdate() throws Exception {
        int id = updatedUserTo.getId();
        perform(post("/" + URL)
                .param("id", String.valueOf(id))
                .param("surname", updatedUserTo.getSurname())
                .param("name", updatedUserTo.getName())
                .param("email", updatedUserTo.getEmail())
                .param("password", updatedUserTo.getPassword()))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/users"));

        USER_TO_MATCHER.assertMatch(UsersUtil.createTo(service.get(id)), updatedUserTo);
    }


    @Test
    void showEnabledForm() throws Exception {
        perform(get("/" + URL + "/enable")
                .param("id", String.valueOf(USER1_ID)))
                .andDo((print()))
                .andExpect(status().isOk())
                .andExpect(view().name("enabled"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/enabled.jsp"))
                .andExpect(model().attribute("user",
                        new AssertionMatcher<UserTo>() {
                            @Override
                            public void assertion(UserTo actual) throws AssertionError {
                                USER_TO_MATCHER.assertMatch(actual, userTo);
                            }
                        }));
    }

    @Test
    void enabled() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter("radio_enabled", String.valueOf(false));
        perform(post("/" + URL + "/enabled")
                .param("id", String.valueOf(USER1_ID + 5))
                .param("request", request.getParameter("radio_enabled")))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        assertFalse(service.get(USER1_ID + 5).isEnabled());
    }
}
