package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Birthday {

    public Birthday() {
    }

    public Birthday(Integer day, MonthType month, Integer year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private Integer day;

    @Column(name = "month")
    @Enumerated(value = EnumType.STRING)
    private MonthType month;

    private Integer year;

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
}
