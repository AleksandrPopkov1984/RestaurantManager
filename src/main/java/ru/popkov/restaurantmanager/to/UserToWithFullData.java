package ru.popkov.restaurantmanager.to;

import ru.popkov.restaurantmanager.model.Role;

import java.beans.ConstructorProperties;
import java.util.Date;
import java.util.Set;

public class UserToWithFullData extends BaseTo {

    private final String surname;
    private final String name;
    private final String email;
    private final String password;
    private final boolean enabled;
    private final Date registered;
    private final Set<Role> roles;

    @ConstructorProperties({"id", "surname", "name", "email", "password", "enabled", "registered", "roles"})
    public UserToWithFullData(Integer id, String surname, String name, String email, String password, boolean enabled, Date registered, Set<Role> roles) {
        super(id);
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.registered = registered;
        this.roles = roles;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Date getRegistered() {
        return registered;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", registered=" + registered +
                ", roles=" + roles +
                ", id=" + id +
                '}';
    }
}
