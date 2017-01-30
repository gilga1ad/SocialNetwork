package util.forms;


import model.MonthType;
import model.RelationshipType;
import model.SexType;
import model.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class UserUpdateForm {

    public UserUpdateForm() {
    }

    public UserUpdateForm(User user) {

        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.sex = user.getSex();
        this.relationshipStatus = user.getRelationshipStatus();
        this.day = user.getBirthday().getDay();
        this.month = user.getBirthday().getMonth();
        this.year = user.getBirthday().getYear();
        this.country = user.getAddress().getCountry();
        this.hometown = user.getAddress().getHometown();
    }

    Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private SexType sex;

    private RelationshipType relationshipStatus;

    @Max(value = 31, message = "Invalid day")
    @Min(value = 1, message = "Invalid day")
    private Integer day;

    private MonthType month;

    @Max(value = 2017, message = "Invalid year")
    @Min(value = 1900, message = "Invalid year")
    private Integer year;

    private String country;

    private String hometown;

    private String photo;

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

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public MonthType getMonth() {
        return month;
    }

    public void setMonth(MonthType month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
