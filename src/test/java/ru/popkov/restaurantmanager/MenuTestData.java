package ru.popkov.restaurantmanager;

import ru.popkov.restaurantmanager.model.Menu;

import java.time.Month;
import java.util.List;

import static java.time.LocalDate.of;
import static ru.popkov.restaurantmanager.RestaurantTestData.restaurant1;
import static ru.popkov.restaurantmanager.RestaurantTestData.restaurant2;
import static ru.popkov.restaurantmanager.RestaurantTestData.restaurant3;
import static ru.popkov.restaurantmanager.RestaurantTestData.restaurant4;
import static ru.popkov.restaurantmanager.RestaurantTestData.restaurant5;
import static ru.popkov.restaurantmanager.model.AbstractBaseEntity.START_SEQ;

public class MenuTestData {

    public static final MatcherFactory.Matcher<Menu> MENU_MATCHER = MatcherFactory.usingIgnoreFieldsComparator("restaurant", "meals");

    public static final int NOT_FOUND = 10;
    public static final int MENU1_ID = START_SEQ + 12;

    public static final Menu menu1 = new Menu(MENU1_ID, of(2022, Month.DECEMBER, 20), restaurant1);
    public static final Menu menu2 = new Menu(MENU1_ID + 1, of(2022, Month.DECEMBER, 20), restaurant2);
    public static final Menu menu3 = new Menu(MENU1_ID + 2, of(2022, Month.DECEMBER, 20), restaurant3);
    public static final Menu menu4 = new Menu(MENU1_ID + 3, of(2022, Month.DECEMBER, 20), restaurant4);
    public static final Menu menu5 = new Menu(MENU1_ID + 4, of(2022, Month.DECEMBER, 20), restaurant5);

    public static final List<Menu> menus = List.of(menu1, menu2, menu3, menu4, menu5);

    public static Menu getNew() {
        return new Menu(null, of(2022, Month.DECEMBER, 22), restaurant2);
    }

    public static Menu getUpdated() {
        return new Menu(MENU1_ID, of(2022, Month.DECEMBER, 21), restaurant5);
    }
}
