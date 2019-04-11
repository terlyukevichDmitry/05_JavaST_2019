package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

public class Client extends Entity {
    @NotNull private String name;
    @NotNull private String surname;
    @NotNull private String patronymic;
    @NotNull private Integer years;
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

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
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
        return "Client{" + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", patronymic='" + patronymic + '\'' + ", years=" + years
                + ", email='" + email + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
