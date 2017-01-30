package repository.Impl;


import model.Post;
import org.springframework.stereotype.Repository;
import repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Post> findAll() {
        TypedQuery<Post> query = em.createQuery("SELECT post FROM Post post", Post.class);
        return query.getResultList();
    }

    @Override
    public Post find(Long id) {
        Post post = em.find(Post.class, id);
        return post;
    }

    @Override
    public void save(Post post) {
        em.persist(post);
    }

    @Override
    public void update(Post post) {
        em.merge(post);
    }

    @Override
    public void remove(Long id) {
        em.remove(em.find(Post.class, id));
    }
    
}
