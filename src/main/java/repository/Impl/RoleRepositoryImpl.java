package repository.Impl;


import model.Role;
import org.springframework.stereotype.Repository;
import repository.RoleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Role findByName(String name) {
        TypedQuery<Role> query = em.createQuery("SELECT role FROM Role role WHERE role.name LIKE :name", Role.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

}
