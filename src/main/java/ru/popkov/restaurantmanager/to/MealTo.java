package ru.popkov.restaurantmanager.to;

import ru.popkov.restaurantmanager.model.Restaurant;

import java.math.BigDecimal;

public class MealTo extends BaseTo {

    private final String name;
    private final BigDecimal price;
    private final Restaurant restaurant;

    public MealTo(Integer id, String name, BigDecimal price, Restaurant restaurant) {
        super(id);
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public String toString() {
        return "MealTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", restaurant=" + restaurant +
                '}';
    }
}
