package model;


public enum MonthType {

    JANUARY("января"), FEBRUARY("февраля"), MARCH("марта"), APRIL("апреля"), MAY("мая"), JUNE("июня"),
    JULY("июля"), AUGUST("августа"), SEPTEMBER("сентября"), OCTOBER("октября"), NOVEMBER("ноября"), DECEMBER("декабря");

    private String name;

    MonthType(String name) {
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
