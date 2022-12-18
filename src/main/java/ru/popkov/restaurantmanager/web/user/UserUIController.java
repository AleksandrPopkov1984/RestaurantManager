package ru.popkov.restaurantmanager.web.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.popkov.restaurantmanager.model.User;
import ru.popkov.restaurantmanager.to.UserTo;
import ru.popkov.restaurantmanager.util.UsersUtil;

import javax.validation.Valid;
import java.util.stream.Collectors;

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
    public String updateOrCreate(@Valid UserTo userTo, BindingResult result) {
        if (result.hasErrors()) {
            String errorFieldsMsg = result.getFieldErrors().stream()
                    .map(fe -> String.format("[%s] %s", fe.getField(), fe.getDefaultMessage()))
                    .collect(Collectors.joining("<br>"));
            return ResponseEntity.unprocessableEntity().body(errorFieldsMsg).toString();
        }
        if (userTo.isNew()) {
            super.create(userTo);
        } else {
            super.update(userTo, userTo.getId());
        }
        return "redirect:/" + URL;
    }
}
