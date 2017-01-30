package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.PostService;
import util.forms.PostForm;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewPost(@ModelAttribute PostForm postForm) {
        postService.savePost(postForm);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") Long id) {
        postService.deletePostById(id);
        return "redirect:/profile";
    }

}
