package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

import java.util.Date;
import java.util.Objects;

public class Review extends Entity {

    @NotNull private String message;
    @NotNull private Client client;
    @NotNull private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
        return "Review{" + "message='" + message + '\'' + ", client=" + client
                + ", date=" + date + '}';
    }
}
