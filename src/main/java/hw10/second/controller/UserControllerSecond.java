package hw10.second.controller;


import hw10.second.model.User;
import hw10.second.service.UserServiceSecond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerSecond {

    private final UserServiceSecond userServiceSecond;

    @Autowired
    public UserControllerSecond(UserServiceSecond userServiceSecond) {
        this.userServiceSecond = userServiceSecond;
    }

    @PostMapping("/save")
    public List<User> save(
            @RequestBody User u) {

        userServiceSecond.save(u);

        return userServiceSecond.findAll();
    }

    @GetMapping
    @ResponseBody
    public List<User> all() {
        return userServiceSecond.findAll();
    }

    @GetMapping("/find/id/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userServiceSecond.findById(id);
    }

    @GetMapping("/find/name/{name}")
    @ResponseBody
    public List<User> findByName(@PathVariable("name") String name) {
        return userServiceSecond.findByName(name);
    }

    @GetMapping("/find/age/{age}")
    @ResponseBody
    public List<User> findByAge(@PathVariable("age") Integer age) {
        return userServiceSecond.findByAge(age);
    }

    @PostMapping("/update/id/{id}")
    public List<User> update(
            @PathVariable("id") Integer id,
            @RequestBody User user) {

        user.setId(id);
        userServiceSecond.save(user);

        return userServiceSecond.findAll();
    }

    @PostMapping("/delete/id/{id}")
    public List<User> delete (@PathVariable("id") Integer id) {

        userServiceSecond.delete(id);

        return userServiceSecond.findAll();
    }

    @PostMapping("/update-age/id/{id}")
    public List<User> updateAge(@PathVariable("id") Integer id,
                                @RequestParam("age") Integer age) {

        userServiceSecond.updateAge(id, age);

        return userServiceSecond.findAll();
    }

}
