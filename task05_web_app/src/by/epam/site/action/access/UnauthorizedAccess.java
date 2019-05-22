package by.epam.site.action.access;

import java.util.ArrayList;
import java.util.List;

/**
 * This class we use for getting access for unauthorized.
 * (Only, What he can do on our site.)
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class UnauthorizedAccess implements Access {
    /**
     * List with the next pages which available for unauthorized.
     */
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
