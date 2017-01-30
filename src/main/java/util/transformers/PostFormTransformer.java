package util.transformers;


import model.Post;
import org.springframework.stereotype.Component;
import util.forms.PostForm;

@Component
public class PostFormTransformer {

    public Post toPost(PostForm form) {
        Post post = new Post(form.getText());
        return post;
    }

}
