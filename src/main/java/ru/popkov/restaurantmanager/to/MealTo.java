package ru.popkov.restaurantmanager.to;

import ru.popkov.restaurantmanager.model.Menu;

import java.math.BigDecimal;

public class MealTo extends BaseTo {

    private final String name;
    private final BigDecimal price;
    private final Menu menu;

    public MealTo(Integer id, String name, BigDecimal price, Menu menu) {
        super(id);
        this.name = name;
        this.price = price;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "MealTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", menu=" + menu +
                '}';
    }
}
