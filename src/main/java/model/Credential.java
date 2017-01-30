package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "credential")
@SequenceGenerator(sequenceName = "credential_seq", name = "credentialSequence")
public class Credential {

    public Credential() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credentialSequence")
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "credential_roles", joinColumns = {
            @JoinColumn(name = "credential_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id",
                    nullable = false)})
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Role> getRoles() {
        if (roles == null) {
            roles = new HashSet<>();
        }
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
