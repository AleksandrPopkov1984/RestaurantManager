package ru.popkov.restaurantmanager.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.popkov.restaurantmanager.to.UserTo;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@ApiIgnore
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
        model.addAttribute("user", new UserTo(null, "", "", "", ""));
        return "userForm";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam int id, Model model) {
        model.addAttribute("user", super.get(id));
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

    @GetMapping("/enable")
    public String showEnabledForm(@RequestParam int id, Model model) {
        model.addAttribute("user", super.get(id));
        return "enabled";
    }

    @PostMapping("/enabled")
    public String enableUser(@RequestParam int id, HttpServletRequest request) {
        boolean enabled = Boolean.parseBoolean(request.getParameter("radio_enabled"));
        super.enable(id, enabled);
        return "redirect:/" + URL;
    }
}
