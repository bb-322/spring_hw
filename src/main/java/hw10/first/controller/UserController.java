package hw10.first.controller;

import hw10.first.service.UserClient;
import hw10.first.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserClient userClient;

    UserController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("remote-user/id/{id}")
    public User getRemoteUser(@PathVariable("id") Integer id) {
        return userClient.getUser(id);
    }

}
