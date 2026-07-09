package hw9.dao;

import hw9.model.User;
import hw9.repo.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public User findById(Integer id) {
        Session s = em.unwrap(Session.class);
        return s.find(User.class, id);
    }

    @Transactional
    public List<User> findAll() {
        Session s = em.unwrap(Session.class);
        return s.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional
    public void save(User user) {
        Session s = em.unwrap(Session.class);
        s.persist(user);
    }

    @Transactional
    public void update(User user, Integer id) {
        Session s = em.unwrap(Session.class);
        user.setId(id);
        s.merge(user);
    }

    @Transactional
    public void delete(Integer id) {
        Session s = em.unwrap(Session.class);
        User u = s.find(User.class, id);
        if (u != null) {
            s.remove(u);
        }
    }

    @Transactional
    public List<User> findByName(String name) {
        Session s = em.unwrap(Session.class);
        return s.createQuery("select u from User u where name=:name", User.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Transactional
    public List<User> findByAge(Integer age) {
        Session s = em.unwrap(Session.class);
        return s.createQuery("select u from User u where age=:age", User.class)
                .setParameter("age", age)
                .getResultList();
    }

    @Transactional
    public void updateAge(Integer id, Integer age) {
        Session s = em.unwrap(Session.class);
        s.createMutationQuery("update User u set u.age = :age where u.id = :id")
                .setParameter("age", age)
                .setParameter("id", id)
                .executeUpdate();
    }

}
