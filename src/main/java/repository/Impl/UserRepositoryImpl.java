package repository.Impl;


import model.User;
import org.springframework.stereotype.Repository;
import repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public User find(Long id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void remove(Long id) {
        em.remove(em.find(User.class, id));
    }

}
