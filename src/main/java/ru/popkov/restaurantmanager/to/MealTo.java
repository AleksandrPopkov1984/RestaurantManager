package ru.popkov.restaurantmanager.to;

import ru.popkov.restaurantmanager.model.Restaurant;

import java.math.BigDecimal;

public class MealTo {

    private final Integer id;
    private final String name;
    private final BigDecimal price;
    private final Restaurant restaurant;

    public MealTo(Integer id, String name, BigDecimal price, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public Integer getId() {
        return id;
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
