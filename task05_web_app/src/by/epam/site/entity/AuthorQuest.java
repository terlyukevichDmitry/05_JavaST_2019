package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

public class AuthorQuest extends Entity{
    @NotNull private String name;
    @NotNull private String surname;
    @NotNull private String patronymic;
    @NotNull private Integer yearOfBirth;
    private Integer yearOfDeath;

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

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(final Integer yearOfBirthT) {
        this.yearOfBirth = yearOfBirthT;
    }

    public Integer getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(Integer yearOfDeathT) {
        this.yearOfDeath = yearOfDeathT;
    }

    @Override
    public String toString() {
        return "AuthorQuest{" + ", name='" + name + '\''
                + ", surname='" + surname + '\'' + ", patronymic='"
                + patronymic + '\'' + ", year_of_birth=" + yearOfBirth
                + ", year_of_death=" + yearOfDeath + '}';
    }
}
