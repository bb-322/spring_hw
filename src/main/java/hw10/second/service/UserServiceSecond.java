package hw10.second.service;

import hw10.second.model.User;
import hw10.second.repository.UserRepositorySecond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceSecond {

    private final UserRepositorySecond userRepositorySecond;

    @Autowired
    public UserServiceSecond(UserRepositorySecond userRepositorySecond) {
        this.userRepositorySecond = userRepositorySecond;
    }

    public User findById(Integer id) {
        return userRepositorySecond.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepositorySecond.findAll();
    }

    public void save(User user) {
        userRepositorySecond.save(user);
    }

    public void delete(Integer id) {
        userRepositorySecond.deleteByIdNative(id);
    }

    public List<User> findByName(String name) {
        return userRepositorySecond.findByName(name);
    }

    public List<User> findByAge(Integer age) {
        return userRepositorySecond.findByAge(age);
    }

    public void updateAge(Integer id, Integer age) {
        userRepositorySecond.updateAge(id, age);
    }

}
