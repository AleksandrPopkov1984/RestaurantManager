package ru.popkov.restaurantmanager.web.vote;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.popkov.restaurantmanager.model.Vote;
import ru.popkov.restaurantmanager.web.SecurityUtil;
import springfox.documentation.annotations.ApiIgnore;

import static ru.popkov.restaurantmanager.service.VoteService.THRESHOLD_TIME_FOR_CHANGING_VOTE;

@ApiIgnore
@Controller
@RequestMapping(VoteUIController.URL)
public class VoteUIController extends AbstractVoteController {

    public static final String URL = "/user/vote";

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public String createOrUpdate(@RequestParam int restaurantId, Model model) {
        int userId = SecurityUtil.safeGet().getId();
        Vote vote = super.getOfUserAndDate(userId);
        if (vote == null) {
            model.addAttribute("vote", super.create(restaurantId, userId));
            model.addAttribute("updated", false);
            model.addAttribute("isPermittedTime", true);
        } else {
            if (super.update(vote.id(), restaurantId, userId)) {
                vote = super.get(vote.id());
                model.addAttribute("vote", vote);
                model.addAttribute("updated", true);
                model.addAttribute("isPermittedTime", true);
            } else {
                model.addAttribute("threshold", THRESHOLD_TIME_FOR_CHANGING_VOTE);
                model.addAttribute("isPermittedTime", false);
            }
        }
        return "vote";
    }
}
