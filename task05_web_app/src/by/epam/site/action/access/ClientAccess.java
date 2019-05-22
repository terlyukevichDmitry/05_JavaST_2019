package by.epam.site.action.access;

import java.util.ArrayList;
import java.util.List;

/**
 * This class we use for getting access for client.
 * (Only, What he can do on our site.)
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ClientAccess implements Access {
    /**
     * List with the next pages which available for client.
     */
    private static List<String> stringList = new ArrayList<>();

    static {
        stringList.add("/home");
        stringList.add("/login");
        stringList.add("/signup");
        stringList.add("/quests");
        stringList.add("/logout");
        stringList.add("/searchByParameter");
        stringList.add("/bookQuest");
        stringList.add("/showQuests");
        stringList.add("/profile");
        stringList.add("/changeValue");
        stringList.add("/changePassword");
        stringList.add("/myQuests");
        stringList.add("/removeOrder");
        stringList.add("/addReview");
        stringList.add("/review");
        stringList.add("/changePhoto");
        stringList.add("/questInformation");
    }

    /**
     * Method for checking access for administrator.
     * @param checkString name of page.
     * @return result, available or not.
     */
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
