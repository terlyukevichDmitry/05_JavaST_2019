package by.epam.site.action.access;

import java.util.ArrayList;
import java.util.List;

public class UnauthorizedAccess implements Access {
    private static List<String> stringList = new ArrayList<>();

    static {
        stringList.add("/home");
        stringList.add("/login");
        stringList.add("/signup");
        stringList.add("/quests");
        stringList.add("/searchByParameter");
        stringList.add("/review");
        stringList.add("/questInformation");
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
