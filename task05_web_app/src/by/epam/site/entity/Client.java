package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class Client extends Entity {
    @NotNull private String name;
    @NotNull private String surname;
    @NotNull private String patronymic;
    @NotNull private Date date_of_birth;
    @NotNull private String email;
    @NotNull private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{id = " + getId() + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", patronymic='" + patronymic + '\'' + ", date_of_birth=" + date_of_birth
                + ", email='" + email + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
