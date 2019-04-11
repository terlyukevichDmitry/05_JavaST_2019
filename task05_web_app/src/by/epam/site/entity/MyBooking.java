package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class MyBooking extends Entity {
    @NotNull private Date date;
    @NotNull private Integer clientId;
    @NotNull private Integer questId;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getQuestId() {
        return questId;
    }

    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    @Override
    public String toString() {
        return "MyBooking{" + "date=" + date + ", clientId=" + clientId
                + ", questId=" + questId + '}';
    }
}
