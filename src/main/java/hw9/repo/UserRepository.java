package hw9.repo;

import hw9.model.User;

import java.util.List;

public interface UserRepository {

    User findById(Integer id);

    List<User> findAll();

    void save(User user);

    void update(User user, Integer id);

    void delete(Integer id);

    List<User> findByName(String name);

    List<User> findByAge(Integer age);

    void updateAge(Integer id, Integer age);

}
