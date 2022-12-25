package ru.popkov.restaurantmanager.util;

import ru.popkov.restaurantmanager.model.Menu;
import ru.popkov.restaurantmanager.to.MenuTo;

import java.util.List;

public class MenusUtil {

    private MenusUtil() {
    }

    public static List<MenuTo> getTos(List<Menu> menus) {
        return menus.stream()
                .map(MenusUtil::createTo)
                .toList();
    }

    public static MenuTo createTo(Menu menu) {
        return new MenuTo(menu.getId(), menu.getDate(), menu.getRestaurant(), menu.getMeals());
    }

    public static Menu createNewFromTo(MenuTo menuTo) {
        return new Menu(null, menuTo.getDate(), menuTo.getRestaurant(), menuTo.getMeals());
    }
}
