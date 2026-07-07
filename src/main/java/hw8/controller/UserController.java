package hw8.controller;

import hw8.service.UserService;
import hw8.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/username/{username}")
    public User findByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }

    @PostMapping("/admin/save")
    public List<User> save(
            @RequestBody User u) {

        userService.register(u);

        return userService.findAll();
    }

    @GetMapping("/id/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PutMapping("/admin/update/id/{id}")
    public List<User> update(
            @PathVariable("id") Integer id,
            @RequestBody User user) {

        user.setId(id);
        userService.save(user);

        return userService.findAll();
    }

    @DeleteMapping("/admin/delete/id/{id}")
    public List<User> delete (@PathVariable("id") Long id) {

        userService.delete(id);

        return userService.findAll();
    }

}
