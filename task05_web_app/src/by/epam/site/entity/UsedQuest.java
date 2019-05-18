package by.epam.site.entity;

import java.time.LocalDate;

public class UsedQuest extends Entity {
    private LocalDate date;
    private Client client;
    private QuestPlace questPlace;
    private Boolean control;

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

    public Boolean getControl() {
        return control;
    }

    public void setControl(Boolean control) {
        this.control = control;
    }

    @Override
    public String toString() {
        return "UsedQuest{" + "id=" + getId() +
                ", date=" + date +
                ", client=" + client +
                ", questPlace=" + questPlace +
                ", control=" + control +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
