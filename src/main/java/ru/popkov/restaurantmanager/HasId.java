package ru.popkov.restaurantmanager;

import org.springframework.util.Assert;

public interface HasId {

    Integer getId();

    void setId(Integer id);

    default boolean isNew() {
        return getId() == null;
    }

    default int id() {
        Assert.notNull(getId(), "Entity must have id");
        return getId();
    }
}
