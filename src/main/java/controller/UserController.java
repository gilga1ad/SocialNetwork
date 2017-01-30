package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import security.SecurityUtils;
import service.ImageService;
import service.UserService;
import util.forms.PostForm;
import util.forms.UserUpdateForm;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showUserPage(@RequestParam(value = "id", required = false) Long id, ModelMap map) {
        User user = (id == null) ? userService.findUserByIdAndFetchPosts(SecurityUtils.getCurrentCredential().getUser().getId())
                : userService.findUserByIdAndFetchPosts(id);
        map.addAttribute("user", user);
        map.addAttribute("postForm", new PostForm());
        return "profile";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showUserEditPage (@PathVariable("id") Long id, ModelMap map) {
        User user = userService.findUserById(id);
        map.addAttribute("userUpdateForm", new UserUpdateForm(user));
        return "edit";
    }

    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("userUpdateForm") @Valid UserUpdateForm userUpdateForm,
                           BindingResult result,
                           @RequestParam(value = "profilePhoto", required=false) MultipartFile file) {
        if (result.hasErrors()) {
            return "edit";
        }
        if (!file.isEmpty()) {
            userUpdateForm.setPhoto(imageService.saveProfilePhoto(file));
        }
        userService.updateUser(userUpdateForm);
        return "redirect:/profile";
    }
    
}
