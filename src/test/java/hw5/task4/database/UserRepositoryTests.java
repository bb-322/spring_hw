package hw5.task4.database;

import hw4.model.User;
import hw4.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = hw4.Main.class)
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public User createTestUser(String name, String lastname, Integer age) {
        User user = new User();
        user.setName(name);
        user.setLastname(lastname);
        user.setAge(age);
        return user;
    }

    @Test
    void findByName_returnsUser() {
        User u = createTestUser("test-name", "test-lastname", 123);
        userRepository.save(u);

        List<User> result = userRepository.findByName(u.getName());

        assertEquals(1, result.size());
        assertEquals(u.getName(), result.get(0).getName());
        assertEquals(u.getLastname(), result.get(0).getLastname());
        assertEquals(u.getAge(), result.get(0).getAge());
    }

    @Test
    void updateAge_updatesAge() {
        User user = createTestUser("test-name", "test-lastname", 123);
        userRepository.save(user);

        User u = userRepository.findByName(user.getName()).get(0);
        Integer id = u.getId();
        Integer newAge = 999;
        userRepository.updateAge(id, newAge);
        entityManager.clear();
        User result = userRepository.findById(id).get();
        assertEquals(newAge, result.getAge());
    }
}
