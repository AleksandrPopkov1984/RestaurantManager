package ru.popkov.restaurantmanager.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RestaurantTo extends BaseTo {

    @NotBlank
    @Size(max = 128)
    private final String name;

    private final Integer voteCount;

    public RestaurantTo(Integer id, String name, Integer voteCount) {
        super(id);
        this.name = name;
        this.voteCount = voteCount;
    }

    public String getName() {
        return name;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "name='" + name + '\'' +
                ", voteCount=" + voteCount +
                ", id=" + id +
                '}';
    }
}
