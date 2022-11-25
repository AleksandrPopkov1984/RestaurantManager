package ru.popkov.restaurantmanager.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "users")
public class RegularUser extends AbstractUser {

    public RegularUser() {
    }

    public RegularUser(Integer id, String surname, String name, String email, String password, boolean enabled, Date registered) {
        super(id, surname, name, email, password, enabled, registered);
    }

    public RegularUser(Integer id, String surname, String name, String email, String password) {
        this(id, surname, name, email, password, true, new Date());
    }
}
