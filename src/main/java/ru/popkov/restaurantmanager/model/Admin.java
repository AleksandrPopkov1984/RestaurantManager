package ru.popkov.restaurantmanager.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "admins")
public class Admin extends AbstractUser {

    public Admin() {
    }

    public Admin(Integer id, String surname, String name, String email, String password, boolean enabled, Date registered) {
        super(id, surname, name, email, password, enabled, registered);
    }

    public Admin(Integer id, String surname, String name, String email, String password, Date registered) {
        this(id, surname, name, email, password, true, registered);
    }
}
