package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

public class Quest extends Entity {
    @NotNull private String title;
    @NotNull private Integer level;
    @NotNull private Integer maxPeople;
    @NotNull private Integer authorId; //or @NotNull private AuthorQuest authorQuest;

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

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Quest{" + "title='" + title + '\'' + ", level=" + level
                + ", maxPeople=" + maxPeople + ", authorId=" + authorId + '}';
    }
}
