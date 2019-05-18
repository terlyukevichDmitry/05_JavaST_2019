package by.epam.site.entity;


import java.time.LocalDate;
import java.util.Objects;

public class Review extends Entity {

    private String message;
    private Client client;
    private LocalDate date;
    private QuestPlace questPlace;

    public QuestPlace getQuestPlace() {
        return questPlace;
    }

    public void setQuestPlace(QuestPlace questPlace) {
        this.questPlace = questPlace;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Review review = (Review) o;
        return Objects.equals(message, review.message) &&
                Objects.equals(client, review.client) &&
                Objects.equals(date, review.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), message, client, date);
    }

    @Override
    public String toString() {
        return "Review{" +
                "message='" + message + '\'' +
                ", client=" + client +
                ", date=" + date +
                ", questPlace=" + questPlace +
                '}';
    }
}
