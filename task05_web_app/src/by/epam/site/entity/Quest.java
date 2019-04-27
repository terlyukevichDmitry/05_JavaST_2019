package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

public class Quest extends Entity {
    @NotNull private String title;
    @NotNull private Integer level;
    @NotNull private Integer maxPeople;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Quest{" +
                "title='" + title + '\'' +
                ", level=" + level +
                ", maxPeople=" + maxPeople +
                '}';
    }
}
