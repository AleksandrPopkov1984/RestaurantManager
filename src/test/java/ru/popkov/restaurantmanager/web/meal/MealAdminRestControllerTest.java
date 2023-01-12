package ru.popkov.restaurantmanager.web.meal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.service.MealService;
import ru.popkov.restaurantmanager.util.exception.NotFoundException;
import ru.popkov.restaurantmanager.web.AbstractControllerTest;
import ru.popkov.restaurantmanager.web.json.JsonUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static ru.popkov.restaurantmanager.MenuTestData.MENU1_ID;
import static ru.popkov.restaurantmanager.TestUtil.userAuth;
import static ru.popkov.restaurantmanager.UserTestData.admin;
import static ru.popkov.restaurantmanager.web.meal.MealAdminRestController.REST_URL;
import static ru.popkov.restaurantmanager.MealTestData.*;

class MealAdminRestControllerTest extends AbstractControllerTest {

    @Autowired
    private MealService service;

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "/" + MEAL1_ID)
                .with(userAuth(admin)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MEAL_TO_MATCHER.contentJson(mealTo1));
    }

    @Test
    void getNotFound() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "/" + NOT_FOUND)
                .with(userAuth(admin)))
                .andDo(print())
                .andExpect(view().name("exception/exception"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/exception/exception.jsp"));
    }

    @Test
    void getOfMenu() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "/ofMenu")
                .param("menuId", String.valueOf(MENU1_ID))
                .with(userAuth(admin)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MEAL_TO_MATCHER.contentJson(List.of(mealTo1, mealTo2, mealTo3, mealTo4, mealTo5)));
    }

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + "/" + MEAL1_ID)
                .with(userAuth(admin)))
                .andDo(print())
                .andExpect(status().isNoContent());

        assertThrows(NotFoundException.class, () -> service.get(MEAL1_ID));
    }

    @Test
    void deleteNotFound() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + "/" + NOT_FOUND)
                .with(userAuth(admin)))
                .andDo(print())
                .andExpect(view().name("exception/exception"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/exception/exception.jsp"));
    }

    @Test
    void createWithLocation() throws Exception {
        Meal newMeal = getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL + "/" + MENU1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newMeal))
                .with(userAuth(admin)))
                .andExpect(status().isCreated());

        Meal created = MEAL_MATCHER.readFromJson(action);
        int newId = created.id();
        newMeal.setId(newId);
        MEAL_MATCHER.assertMatch(created, newMeal);
        MEAL_MATCHER.assertMatch(service.get(newId), newMeal);
    }

    @Test
    void update() throws Exception {
        Meal updated = getUpdated();
        perform(MockMvcRequestBuilders.put(REST_URL + "/" + MEAL1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated))
                .with(userAuth(admin)))
                .andExpect(status().isNoContent());

        MEAL_MATCHER.assertMatch(service.get(MEAL1_ID), updated);
    }
}