package model;


public enum RelationshipType {

    SINGLE("Не женат"), INARELATIONSHIP("Встречаюсь"), MARRIED("Женат"), INLOVE("Влюблен");

    private String name;

    RelationshipType(String name) {
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
