package ru.popkov.restaurantmanager.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserTo extends BaseTo {

    @NotBlank
    @Size(max = 128)
    private final String surname;

    @NotBlank
    @Size(max = 128)
    private final String name;

    @Email
    @NotBlank
    private final String email;

    @NotBlank
    @Size(min = 5, max = 25)
    private final String password;

    private final boolean enabled;

    public UserTo(Integer id, String surname, String name, String email, String password, boolean enabled) {
        super(id);
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
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
}
