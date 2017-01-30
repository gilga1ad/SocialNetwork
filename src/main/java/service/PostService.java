package service;

import util.forms.PostForm;

public interface PostService {

    void savePost(PostForm form);

    void deletePostById(Long id);

}
