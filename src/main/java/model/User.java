package model;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@SequenceGenerator(sequenceName = "users_seq", name = "userSequence")
public class User {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(name = "sex")
    @Enumerated(value = EnumType.STRING)
    private SexType sex;

    @Enumerated(value = EnumType.STRING)
    private RelationshipType relationshipStatus;

    @Embedded
    private Birthday birthday;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderColumn(name = "order_id")
    private List<Post> posts = new ArrayList<>();

    private String photo;

    @ManyToMany
    @JoinTable(name = "user_friend", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "friend_id", nullable = false)})
    private List<User> friends;

    @ManyToMany(mappedBy = "friends")
    private List<User> friendsOf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public RelationshipType getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(RelationshipType relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public Birthday getBirthday() {
        if (birthday == null) {
            birthday = new Birthday();
        }
        return birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        if (address == null) {
            address = new Address();
        }
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<User> getFriendsOf() {
        return friendsOf;
    }

    public void setFriendsOf(List<User> friendsOf) {
        this.friendsOf = friendsOf;
    }
}
