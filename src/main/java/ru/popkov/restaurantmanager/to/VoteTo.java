package ru.popkov.restaurantmanager.to;

import ru.popkov.restaurantmanager.model.Restaurant;

import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.time.LocalTime;

public class VoteTo extends BaseTo {

    private int userId;
    private Restaurant restaurant;
    private LocalDate date;
    private LocalTime time;
    private String status;

    @ConstructorProperties({"id", "userId", "restaurant", "date", "time", "status"})
    public VoteTo(Integer id, int userId, Restaurant restaurant, LocalDate date, LocalTime time, String status) {
        super(id);
        this.userId = userId;
        this.restaurant = restaurant;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VoteTo{" +
                "userId=" + userId +
                ", restaurant=" + restaurant +
                ", date=" + date +
                ", time=" + time +
                ", status='" + status + '\'' +
                ", id=" + id +
                '}';
    }
}
