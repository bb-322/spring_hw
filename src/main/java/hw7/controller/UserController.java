package hw7.controller;


import hw7.model.User;
import hw7.service.UserService;
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

    @PostMapping("/save")
    public List<User> save(
            @RequestBody User u) {

        userService.save(u);

        return userService.findAll();
    }

    @GetMapping
    @ResponseBody
    public List<User> all() {
        return userService.findAll();
    }

    @GetMapping("/find/id/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/find/name/{name}")
    @ResponseBody
    public List<User> findByName(@PathVariable("name") String name) {
        return userService.findByName(name);
    }

    @GetMapping("/find/age/{age}")
    @ResponseBody
    public List<User> findByAge(@PathVariable("age") Integer age) {
        return userService.findByAge(age);
    }

    @PostMapping("/update/id/{id}")
    public List<User> update(
            @PathVariable("id") Integer id,
            @RequestBody User user) {

        user.setId(id);
        userService.save(user);

        return userService.findAll();
    }

    @PostMapping("/delete/id/{id}")
    public List<User> delete (@PathVariable("id") Integer id) {

        userService.delete(id);

        return userService.findAll();
    }

    @PostMapping("/update-age/id/{id}")
    public List<User> updateAge(@PathVariable("id") Integer id,
                            @RequestParam("age") Integer age) {

        userService.updateAge(id, age);

        return userService.findAll();
    }

}
