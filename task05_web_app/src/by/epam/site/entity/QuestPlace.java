package by.epam.site.entity;

import com.sun.istack.internal.NotNull;

public class QuestPlace extends Entity {
    @NotNull private String title;
    @NotNull private String adress;
    @NotNull private String phone;
    @NotNull private Integer questId; //@NotNull private Quest Quest;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getQuestId() {
        return questId;
    }

    public void setQuestId(Integer questId) {
        questId = questId;
    }

    @Override
    public String toString() {
        return "QuestPlace{" + "title='" + title + '\'' + ", adress='"
                + adress + '\'' + ", phone='" + phone + '\''
                + ", questId=" + questId + '}';
    }
}
