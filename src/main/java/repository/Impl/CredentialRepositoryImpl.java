package repository.Impl;


import model.Credential;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.CredentialRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class CredentialRepositoryImpl implements CredentialRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Credential credential) {
        em.persist(credential);
    }

    @Override
    public void update(Credential credential) {
        em.merge(credential);
    }

    @Override
    public void remove(Long id) {
        em.remove(em.find(Credential.class, id));
    }

    @Override
    public Credential findByEmail(String email) {
        TypedQuery<Credential> query = em.createQuery("SELECT credential FROM Credential credential WHERE credential.email LIKE :email",
                Credential.class);
        query.setParameter("email", email);
        Credential credential;
        try {
            credential = query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return credential;
    }

}
