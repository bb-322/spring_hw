package hw4.controller;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import hw4.model.User;
import hw4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String home() {
        return "hw4/users";
    }

    @PostMapping
    public String save(
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastname,
            @RequestParam("age") Integer age) {
        User u = new User();
        u.setName(name);
        u.setLastname(lastname);
        u.setAge(age);

        userService.save(u);
        return "redirect:/users";
    }

    @GetMapping("/api/all")
    @ResponseBody
    public List<User> all() {
        return userService.findAll();
    }

    @GetMapping("/find")
    public String findById(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("user", userService.findById(id));
        return "hw4/user";
    }

    @GetMapping("/find/by-name")
    @ResponseBody
    public List<User> findByName(@RequestParam("name") String name) {
        return userService.findByName(name);
    }

    @GetMapping("/find/by-age")
    @ResponseBody
    public List<User> findByAge(@RequestParam("age") Integer age) {
        return userService.findByAge(age);
    }

    @PostMapping("/update")
    public String update(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastname,
            @RequestParam("age") Integer age) {
        User u = new User();
        u.setId(id);
        u.setName(name);
        u.setLastname(lastname);
        u.setAge(age);

        userService.save(u);

        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete (@RequestParam("id") Integer id) {
        userService.delete(id);

        return "redirect:/users";
    }

    @PostMapping("/update-age")
    public String updateAge(@RequestParam("id") Integer id,
                            @RequestParam("age") Integer age) {
        userService.updateAge(id, age);
        return "redirect:/users";
    }

}
