package ru.popkov.restaurantmanager.web.vote;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.popkov.restaurantmanager.model.Vote;
import ru.popkov.restaurantmanager.to.VoteTo;
import ru.popkov.restaurantmanager.web.SecurityUtil;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController extends AbstractVoteController {

    public static final String REST_URL = "/rest/user/vote";

    @GetMapping("/{restaurantId}")
    public VoteTo vote(@PathVariable int restaurantId) {
        int userId = SecurityUtil.safeGet().getId();
        Vote vote = super.getOfUserAndDate(userId);
        if (vote == null) {
            return super.createTo(restaurantId, userId);
        } else {
            if (super.update(vote.id(), restaurantId, userId)) {
                return super.getTo(vote.id(), "updated");
            } else {
                return super.getTo(vote.id(), "not updated, too late");
            }
        }
    }
}
