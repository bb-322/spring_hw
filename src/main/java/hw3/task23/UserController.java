package hw3.task23;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    @GetMapping("/")
    public String form(Model model) {

        model.addAttribute("user", new User());
        return "hw3/task23/form";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user, Model model) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Path p = Path.of("users.json");
        List<User> users;

        if (p.toFile().exists()) {
            users = mapper.readValue(
                    p.toFile(),
                    new TypeReference<List<User>>() {}
            );
        } else {
            users = new ArrayList<>();
        }

        users.add(user);

        mapper.writerWithDefaultPrettyPrinter().writeValue(p.toFile(), users);


        model.addAttribute("count", users.size());

        return "hw3/task23/success";

    }

    @GetMapping("/data")
    public String data(Model model) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        List<User> users = mapper.readValue(
                Path.of("users.json").toFile(),
                new TypeReference<List<User>>() {}
        );

        String json = new ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(users);

        model.addAttribute("data", json);

        return "hw3/task23/data";
    }

}
