package ru.popkov.restaurantmanager;

import ru.popkov.restaurantmanager.model.Meal;
import ru.popkov.restaurantmanager.to.MealTo;

import java.math.BigDecimal;
import java.util.List;

import static ru.popkov.restaurantmanager.MenuTestData.menu1;
import static ru.popkov.restaurantmanager.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {

    public static final MatcherFactory.Matcher<Meal> MEAL_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Meal.class, "menu");
    public static final MatcherFactory.Matcher<MealTo> MEAL_TO_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(MealTo.class, "menu");

    public static final int NOT_FOUND = 10;
    public static final int MEAL1_ID = START_SEQ + 17;

    public static final Meal meal1 = new Meal(MEAL1_ID, "Куриный бульон", BigDecimal.valueOf(260));
    public static final Meal meal2 = new Meal(MEAL1_ID + 1, "Солянка мясная", BigDecimal.valueOf(390));
    public static final Meal meal3 = new Meal(MEAL1_ID + 2, "Уха из ладожского судака", BigDecimal.valueOf(760));
    public static final Meal meal4 = new Meal(MEAL1_ID + 3, "Рыбные котлеты с соусом по-польски", BigDecimal.valueOf(600));
    public static final Meal meal5 = new Meal(MEAL1_ID + 4, "Медальоны из лосося с овощами", BigDecimal.valueOf(950));
    public static final Meal meal6 = new Meal(MEAL1_ID + 5, "Том Ям с морепродуктами", BigDecimal.valueOf(530));
    public static final Meal meal7 = new Meal(MEAL1_ID + 6, "Филадельфия Люкс", BigDecimal.valueOf(580));
    public static final Meal meal8 = new Meal(MEAL1_ID + 7, "Ролл Запеченый краб", BigDecimal.valueOf(300));
    public static final Meal meal9 = new Meal(MEAL1_ID + 8, "Борщ", BigDecimal.valueOf(680));
    public static final Meal meal10 = new Meal(MEAL1_ID + 9, "Стейк Рибай", BigDecimal.valueOf(1350));
    public static final Meal meal11 = new Meal(MEAL1_ID + 10, "Шашлык куриный", BigDecimal.valueOf(1000));
    public static final Meal meal12 = new Meal(MEAL1_ID + 11, "Салат из овощей", BigDecimal.valueOf(450));
    public static final Meal meal13 = new Meal(MEAL1_ID + 12, "Цезарь с креветками", BigDecimal.valueOf(780));
    public static final Meal meal14 = new Meal(MEAL1_ID + 13, "Мюнхенские колбаски", BigDecimal.valueOf(750));
    public static final Meal meal15 = new Meal(MEAL1_ID + 14, "Филе семги", BigDecimal.valueOf(2000));
    public static final Meal meal16 = new Meal(MEAL1_ID + 15, "Уха из трех видов рыбы", BigDecimal.valueOf(780));
    public static final Meal meal17 = new Meal(MEAL1_ID + 16, "Котлеты из щуки", BigDecimal.valueOf(920));

    public static final MealTo mealTo1 = new MealTo(MEAL1_ID, "Куриный бульон", BigDecimal.valueOf(260), menu1);
    public static final MealTo mealTo2 = new MealTo(MEAL1_ID + 1, "Солянка мясная", BigDecimal.valueOf(390), menu1);
    public static final MealTo mealTo3 = new MealTo(MEAL1_ID + 2, "Уха из ладожского судака", BigDecimal.valueOf(760), menu1);
    public static final MealTo mealTo4 = new MealTo(MEAL1_ID + 3, "Рыбные котлеты с соусом по-польски", BigDecimal.valueOf(600), menu1);
    public static final MealTo mealTo5 = new MealTo(MEAL1_ID + 4, "Медальоны из лосося с овощами", BigDecimal.valueOf(950), menu1);

    public static final List<Meal> meals = List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7, meal8, meal9, meal10,
            meal11, meal12, meal13, meal14, meal15, meal16, meal17);

    public static final MealTo mealTo = new MealTo(MEAL1_ID, "Куриный бульон", BigDecimal.valueOf(260), null);
    public static final MealTo newMealTo = new MealTo(null, "", BigDecimal.valueOf(100), null);
    public static final MealTo updatedMealTo = new MealTo(MEAL1_ID, "Куриный бульон", BigDecimal.valueOf(388), menu1);

    public static Meal getNew() {
        return new Meal(null, "Рыбный суп", BigDecimal.valueOf(500));
    }

    public static Meal getUpdated() {
        return new Meal(MEAL1_ID, "Куриный бульон", BigDecimal.valueOf(350));
    }
}
