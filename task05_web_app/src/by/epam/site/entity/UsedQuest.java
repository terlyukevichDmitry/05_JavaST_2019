package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class UsedQuest extends Entity {
    @NotNull private Date date;
    @NotNull private Client client;
    @NotNull private QuestPlace questPlace;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public QuestPlace getQuestPlace() {
        return questPlace;
    }

    public void setQuestPlace(QuestPlace questPlace) {
        this.questPlace = questPlace;
    }

    @Override
    public String toString() {
        return "UsedQuest{" +
                "date=" + date +
                ", client=" + client +
                ", questPlace=" + questPlace +
                '}';
    }
}
