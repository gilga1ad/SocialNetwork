package model;


public enum SexType {

    MALE("Мужской"), FEMALE("Женский");

    private String name;

    SexType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
