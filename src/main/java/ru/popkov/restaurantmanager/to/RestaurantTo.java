package ru.popkov.restaurantmanager.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RestaurantTo extends BaseTo {

    @NotBlank
    @Size(max = 128)
    private final String name;

    public RestaurantTo(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
