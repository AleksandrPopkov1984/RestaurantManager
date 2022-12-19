package ru.popkov.restaurantmanager.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.popkov.restaurantmanager.to.UserTo;
import ru.popkov.restaurantmanager.util.UsersUtil;

import javax.validation.Valid;

@Controller
@RequestMapping(UserUIController.URL)
public class UserUIController extends AbstractUserController {

    public static final String URL = "admin/users";

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("users", super.getAll());
        return "users";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserTo(null, "", "", "", "", true));
        return "userForm";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam int id, Model model) {
        model.addAttribute("user", UsersUtil.createTo(super.get(id)));
        return "userForm";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        super.delete(id);
        return "redirect:/" + URL;
    }

    @PostMapping
    public String updateOrCreate(@Valid UserTo userTo) {
        if (userTo.isNew()) {
            super.create(userTo);
        } else {
            super.update(userTo, userTo.getId());
        }
        return "redirect:/" + URL;
    }
}
