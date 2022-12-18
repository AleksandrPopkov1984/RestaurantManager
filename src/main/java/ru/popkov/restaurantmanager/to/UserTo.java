package ru.popkov.restaurantmanager.to;

public class UserTo extends BaseTo {

    private final String surname;
    private final String name;
    private final String email;
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
