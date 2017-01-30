package service;

import model.User;
import util.forms.UserUpdateForm;

public interface UserService {

    void updateUser(UserUpdateForm form);

    User findUserById(Long id);

    User findUserByIdAndFetchPosts(Long id);
}
