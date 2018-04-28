package by.tc.task01.entity;

import java.util.Objects;

public class Newspaper extends Appliance {

    private String title;
    private String periodicity;
    private String paidFree;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getPaidFree() {
        return paidFree;
    }

    public void setPaidFree(String paidFree) {
        this.paidFree = paidFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Newspaper newspaper = (Newspaper) o;
        return Objects.equals(title, newspaper.title) &&
                Objects.equals(periodicity, newspaper.periodicity) &&
                Objects.equals(paidFree, newspaper.paidFree);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, periodicity, paidFree);
    }

    @Override
    public String toString() {
        return "Newspaper: " +
                "title = '" + title + '\'' +
                ", periodicity = '" + periodicity + '\'' +
                ", paidFree = '" + paidFree;
    }
}
