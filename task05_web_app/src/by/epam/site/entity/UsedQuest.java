package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

import java.time.LocalDate;
import java.util.Date;

public class UsedQuest extends Entity {
    @NotNull private LocalDate date;
    @NotNull private Client client;
    @NotNull private QuestPlace questPlace;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
        return "UsedQuest{" + "id=" + getId() + ", date=" + date + ", client="
                + client + ", questPlace=" + questPlace + '}';
    }
}
