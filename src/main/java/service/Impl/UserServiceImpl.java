package service.Impl;


import model.Address;
import model.Birthday;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserRepository;
import service.UserService;
import util.forms.UserUpdateForm;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public void updateUser(UserUpdateForm form) {
        User user = userRepository.find(form.getId());

        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setSex(form.getSex());
        user.setRelationshipStatus(form.getRelationshipStatus());
        user.setBirthday(new Birthday(form.getDay(), form.getMonth(), form.getYear()));
        user.setAddress(new Address(form.getCountry(), form.getHometown()));
        if (form.getPhoto() != null) { user.setPhoto(form.getPhoto()); }
    }

    @Override
    public User findUserById(Long id) {
        User user = userRepository.find(id);
        return user;
    }

    @Override
    public User findUserByIdAndFetchPosts(Long id) {
        User user = userRepository.find(id);
        user.getPosts().size();
        return user;
    }

}
