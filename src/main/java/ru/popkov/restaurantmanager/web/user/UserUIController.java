package ru.popkov.restaurantmanager.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.popkov.restaurantmanager.model.User;

@Controller
@RequestMapping(UserUIController.URL)
public class UserUIController extends AbstractUserController {

    public static final String URL = "admin/users";

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("users", super.getAll());
        return "users";
    }

    @Override
    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return get(id);
    }

    @PostMapping
    public User createUser(User user) {
        return super.create(user);
    }

    @PostMapping("/update")
    public void updateUser(User user, int id) {
        super.update(user, id);
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        super.delete(id);
        return "redirect:/" + URL;
    }
}
