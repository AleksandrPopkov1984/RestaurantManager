package ru.popkov.restaurantmanager.to;

import ru.popkov.restaurantmanager.model.Menu;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class MealTo extends BaseTo {

    @NotBlank
    @Size(max = 128)
    private final String name;

    @Positive
    private final BigDecimal price;

    @NotNull
    private final Menu menu;

    public MealTo(Integer id, String name, BigDecimal price, Menu menu) {
        super(id);
        this.name = name;
        this.price = price;
        this.menu = menu;
    }

    public MealTo(Integer id, String name, BigDecimal price) {
        this(id, name, price, null);
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
