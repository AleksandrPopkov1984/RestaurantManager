package ru.popkov.restaurantmanager.web.menu;

import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.popkov.restaurantmanager.model.Menu;
import ru.popkov.restaurantmanager.service.MenuService;
import ru.popkov.restaurantmanager.to.MenuTo;
import ru.popkov.restaurantmanager.util.exception.NotFoundException;
import ru.popkov.restaurantmanager.web.AbstractControllerTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.popkov.restaurantmanager.RestaurantTestData.RESTAURANT1_ID;
import static ru.popkov.restaurantmanager.web.menu.MenuAdminUIController.URL;
import static ru.popkov.restaurantmanager.MenuTestData.*;

class MenuAdminUIControllerTest extends AbstractControllerTest {

    @Autowired
    private MenuService service;

    @Test
    void getOfRestaurant() throws Exception {
        perform(get(URL)
                .param("restaurantId", String.valueOf(RESTAURANT1_ID)))
                .andDo(print())
                .andExpect(view().name("menus"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/menus.jsp"))
                .andExpect(model().attribute("menus",
                        new AssertionMatcher<List<Menu>>() {
                            @Override
                            public void assertion(List<Menu> actual) throws AssertionError {
                                MENU_MATCHER.assertMatch(actual, List.of(menu1));
                            }
                        }));
    }

    @Test
    void delete() throws Exception {
        perform(get(URL + "/delete")
                .param("id", String.valueOf(MENU1_ID))
                .param("restaurantId", String.valueOf(RESTAURANT1_ID)))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        assertThrows(NotFoundException.class, () -> service.get(MENU1_ID));
    }

    @Test
    void create() throws Exception {
        perform(get(URL + "/create")
                .param("restaurantId", String.valueOf(RESTAURANT1_ID)))
                .andDo(print())
                .andExpect(view().name("menuForm"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/menuForm.jsp"))
                .andExpect(model().attribute("menu",
                        new AssertionMatcher<MenuTo>() {
                            @Override
                            public void assertion(MenuTo actual) throws AssertionError {
                                MENU_TO_MATCHER.assertMatch(actual, newMenuTo);
                            }
                        }));
    }
}