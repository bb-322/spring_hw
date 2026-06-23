package hw7.service;

import hw7.model.User;
import hw7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteByIdNative(id);
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findByAge(Integer age) {
        return userRepository.findByAge(age);
    }

    public void updateAge(Integer id, Integer age) {
        userRepository.updateAge(id, age);
    }

}
