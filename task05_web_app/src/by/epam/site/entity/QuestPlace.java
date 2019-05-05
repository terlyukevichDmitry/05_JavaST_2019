package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

public class QuestPlace extends Entity {
    @NotNull private String name;
    @NotNull private String address;
    @NotNull private String phone;
    @NotNull private Quest quest;
    @NotNull private Image image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "QuestPlace{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", quest=" + quest +
                ", image=" + image +
                '}';
    }
}
