package ru.popkov.restaurantmanager.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractUser extends AbstractBaseEntity {

    @Column(name = "surname", nullable = false)
    @NotBlank
    @Size(max = 128)
    protected String surname;

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(max = 128)
    protected String name;

    @Column(name ="email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 128)
    protected String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 25)
    protected String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    protected boolean enabled = true;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
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
