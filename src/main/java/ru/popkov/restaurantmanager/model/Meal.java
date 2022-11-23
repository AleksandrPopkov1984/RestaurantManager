package ru.popkov.restaurantmanager.model;

import java.math.BigDecimal;

public class Meal extends AbstractBaseEntity{

    private String name;

    private BigDecimal price;

    private Restaurant restaurant;

    public Meal() {
    }

    public Meal(String name, BigDecimal price) {
        this(null, name, price);
    }

    public Meal(Integer id, String name, BigDecimal price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", restaurant=" + restaurant +
                '}';
    }
}
