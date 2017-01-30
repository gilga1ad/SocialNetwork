package service.Impl;


import model.Post;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PostRepository;
import security.SecurityUtils;
import service.PostService;
import util.forms.PostForm;

import org.springframework.transaction.annotation.Transactional;
import util.transformers.PostFormTransformer;

@Service
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostFormTransformer transformer;

    @Transactional
    @Override
    public void savePost(PostForm form) {
        Post post = transformer.toPost(form);
        User user = SecurityUtils.getCurrentCredential().getUser();
        post.setUser(user);
        postRepository.save(post);
    }

    @Transactional
    @Override
    public void deletePostById(Long id) {
        postRepository.remove(id);
    }

}
