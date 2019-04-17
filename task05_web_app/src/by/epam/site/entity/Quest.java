package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Quest extends Entity {
    @NotNull private String title;
    @NotNull private Integer level;
    @NotNull private Integer maxPeople;
    @NotNull private AuthorQuest authorQuest;
    @NotNull private List<Review> reviewList;

    public Quest() {
        reviewList = new ArrayList<>();
    }

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

    public AuthorQuest getAuthorQuest() {
        return authorQuest;
    }

    public void setAuthorQuest(final AuthorQuest authorQuest) {
        this.authorQuest = authorQuest;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(final Review review) {
        reviewList.add(review);
    }

    @Override
    public String toString() {
        return "Quest{" +
                "title='" + title + '\'' +
                ", level=" + level +
                ", maxPeople=" + maxPeople +
                ", authorQuest=" + authorQuest +
                ", reviewList=" + reviewList +
                '}';
    }
}