package repository;


import model.User;

public interface UserRepository {


    User find(Long id);

    void save(User user);

    void update(User user);

    void remove(Long id);

}
