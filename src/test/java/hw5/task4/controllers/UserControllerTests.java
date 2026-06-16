package hw5.task4.controllers;

import hw4.model.User;
import hw4.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = hw4.Main.class)
@AutoConfigureMockMvc
@Transactional
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    public User createTestUser(String name, String lastname, Integer age) {
        User user = new User();
        user.setName(name);
        user.setLastname(lastname);
        user.setAge(age);
        return user;
    }

    @Test
    void findByName_returns_user_list() throws Exception {
        User u1 = createTestUser("test-name",  "test-lastname1", 1);
        User u2 = createTestUser("test-name",  "test-lastname2", 999);

        userRepository.saveAndFlush(u1);
        userRepository.saveAndFlush(u2);

        mockMvc.perform(get("/users/find/by-name?name=test-name"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("test-name"))
                .andExpect(jsonPath("$[0].lastname").value("test-lastname1"))
                .andExpect(jsonPath("$[0].age").value(1))
                .andExpect(jsonPath("$[1].name").value("test-name"))
                .andExpect(jsonPath("$[1].lastname").value("test-lastname2"))
                .andExpect(jsonPath("$[1].age").value(999));
    }

    @Test
    void home_returns_users() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(view().name("hw4/users"));
    }

}
