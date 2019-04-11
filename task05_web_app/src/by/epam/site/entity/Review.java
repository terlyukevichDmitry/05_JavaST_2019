package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class Review extends Entity {
    @NotNull private String message;
    @NotNull private Integer clientId;
    @NotNull private Date date;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Review{" + "message='" + message + '\''
                + ", clientId=" + clientId + ", date=" + date + '}';
    }
}
