package ru.popkov.restaurantmanager.to;

import ru.popkov.restaurantmanager.model.Menu;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class MealTo extends BaseTo {

    @NotBlank
    @Size(max = 128)
    private String name;

    @Positive
    private BigDecimal price;

    private Menu menu;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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
