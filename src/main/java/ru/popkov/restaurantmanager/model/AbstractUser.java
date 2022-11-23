package ru.popkov.restaurantmanager.model;

import java.util.Date;

public abstract class AbstractUser extends AbstractBaseEntity {

    protected String surname;

    protected String name;

    protected String email;

    protected String password;

    protected boolean enabled = true;

    protected Date registered;

    public AbstractUser() {
    }

    public AbstractUser(Integer id, String surname, String name, String email, String password, boolean enabled, Date registered) {
        super(id);
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.registered = registered;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "AbstractUser{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", registered=" + registered +
                '}';
    }
}
