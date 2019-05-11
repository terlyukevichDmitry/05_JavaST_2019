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
