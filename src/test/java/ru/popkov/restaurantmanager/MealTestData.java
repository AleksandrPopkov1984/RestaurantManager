package ru.popkov.restaurantmanager;

import ru.popkov.restaurantmanager.model.Meal;

import java.math.BigDecimal;
import java.util.List;

import static ru.popkov.restaurantmanager.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {

    public static final MatcherFactory.Matcher<Meal> MEAL_MATCHER = MatcherFactory.usingIgnoreFieldsComparator("restaurant");

    public static final int NOT_FOUND = 10;
    public static final int MEAL1_ID = START_SEQ + 12;

    public static final Meal meal1 = new Meal(MEAL1_ID, "Chicken and Bacon", BigDecimal.valueOf(200));
    public static final Meal meal2 = new Meal(MEAL1_ID + 1, "Steak and Onion Ciabatta", BigDecimal.valueOf(300));
    public static final Meal meal3 = new Meal(MEAL1_ID + 2, "Sausage and Onion Sandwich", BigDecimal.valueOf(250));
    public static final Meal meal4 = new Meal(MEAL1_ID + 3, "Lamb & Apricot Curry", BigDecimal.valueOf(600));
    public static final Meal meal5 = new Meal(MEAL1_ID + 4, "Roasted Chicken Legs", BigDecimal.valueOf(400));
    public static final Meal meal6 = new Meal(MEAL1_ID + 5, "Sweet & Sour Pork", BigDecimal.valueOf(200));
    public static final Meal meal7 = new Meal(MEAL1_ID + 6, "Fish Fingers", BigDecimal.valueOf(310));
    public static final Meal meal8 = new Meal(MEAL1_ID + 7, "Mixed Salad", BigDecimal.valueOf(550));
    public static final Meal meal9 = new Meal(MEAL1_ID + 8, "Ginger Sponge Pudding", BigDecimal.valueOf(480));
    public static final Meal meal10 = new Meal(MEAL1_ID + 9, "Baked Beans", BigDecimal.valueOf(150));

    public static final List<Meal> meals = List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7, meal8, meal9, meal10);

    public static Meal getNew() {
        return new Meal(null, "Fish soup", BigDecimal.valueOf(500));
    }

    public static Meal getUpdated() {
        return new Meal(MEAL1_ID, "Chicken and Bacon", BigDecimal.valueOf(350));
    }
}
