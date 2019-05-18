package by.epam.site.entity;


import java.time.LocalDate;

public class Client extends Entity {
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String email;
    private String phone;
    private String filePath;

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Client{" + "id='" + getId() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", filePath='" + filePath + '\'' +
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
