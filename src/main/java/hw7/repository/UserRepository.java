package hw7.repository;

import hw7.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByName(String name);
    public List<User> findByAge(Integer age);

    @Modifying
    @Transactional
    @Query("update User u set u.age = :age where u.id = :id")
    void updateAge(@Param("id") Integer id, @Param("age") Integer newAge);

    @Modifying
    @Transactional
    @Query(value = "delete from user where id = :id", nativeQuery = true)
    void deleteByIdNative(@Param("id") Integer id);

}
