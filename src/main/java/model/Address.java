package model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    public Address() {
    }

    public Address(String country, String hometown) {
        this.country = country;
        this.hometown = hometown;
    }

    private String country;

    private String hometown;

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
}
