package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class UsedQuest extends Entity{
    @NotNull private String title;
    @NotNull private Date date;
    @NotNull private Integer level;
    @NotNull private Integer clientId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "UsedQuest{" + "title='" + title + '\'' + ", date=" + date
                + ", level=" + level + ", clientId=" + clientId + '}';
    }
}
