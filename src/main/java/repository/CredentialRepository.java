package repository;


import model.Credential;
import model.User;

public interface CredentialRepository {

    void save(Credential credential);

    void update(Credential credential);

    void remove(Long id);

    Credential findByEmail(String email);

}
