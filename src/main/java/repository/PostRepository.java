package repository;


import model.Post;

import java.util.List;

public interface PostRepository {

    List<Post> findAll();

    Post find(Long id);

    void save(Post post);

    void update(Post post);

    void remove(Long id);

}
