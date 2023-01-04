package ru.popkov.restaurantmanager.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import ru.popkov.restaurantmanager.to.UserTo;
import ru.popkov.restaurantmanager.web.SecurityUtil;

import javax.validation.Valid;

@Controller
@RequestMapping(ProfileUIController.URL)
public class ProfileUIController extends AbstractUserController {

    public static final String URL = "/profile";

    @GetMapping
    public String profile() {
        return "profile";
    }

    @PostMapping
    public String updateProfile(@Valid UserTo userTo, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "profile";
        } else {
            super.update(userTo, SecurityUtil.authUserId());
            SecurityUtil.get().setTo(userTo);
            status.setComplete();
            return "redirect:/";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userTo", new UserTo(null, "", "", "", ""));
        model.addAttribute("register", true);
        return "profile";
    }

    @PostMapping("/register")
    public String saveRegister(@Valid UserTo userTo, BindingResult result, SessionStatus status, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("register", true);
            return "profile";
        } else {
            super.create(userTo);
            status.setComplete();
            return "redirect:/login?message=registered&username=" + userTo.getEmail();
        }
    }
}
