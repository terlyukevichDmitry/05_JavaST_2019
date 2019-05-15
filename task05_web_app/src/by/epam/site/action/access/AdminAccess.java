package by.epam.site.action.access;

import java.util.ArrayList;
import java.util.List;

public class AdminAccess implements Access {
    private static List<String> stringList = new ArrayList<>();

    static {
        stringList.add("/home");
        stringList.add("/login");
        stringList.add("/signup");
        stringList.add("/quests");
        stringList.add("/removePath");
        stringList.add("/logout");
        stringList.add("/showUsers");
        stringList.add("/searchByParameter");
        stringList.add("/bookQuest");
        stringList.add("/showQuests");
        stringList.add("/profile");
        stringList.add("/removeUser");
        stringList.add("/changeValue");
        stringList.add("/changePassword");
        //stringList.add("/myQuests");
        stringList.add("/removeOrder");
        stringList.add("/goToProfile");
        stringList.add("/removeOrderByAdmin");
        stringList.add("/deny");
        stringList.add("/acceptOrder");
        stringList.add("/removePerson");
        stringList.add("/addReview");
        stringList.add("/review");
        stringList.add("/removeReview");
        stringList.add("/createQuest");
        stringList.add("/createNewQuest");
        stringList.add("/changePhoto");
        stringList.add("/removeQuest");
        stringList.add(("/questInformation"));
    }
    @Override
    public boolean checkAccess(final String checkString) {
        for (String string : stringList) {
            if (checkString.equals(string)) {
                return true;
            }
        }
        return false;
    }
}
