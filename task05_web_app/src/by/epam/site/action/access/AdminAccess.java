package by.epam.site.action.access;

import java.util.ArrayList;
import java.util.List;

/**
 * This class we use for getting access for administrator.
 * (Only, What he can do on our site.)
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class AdminAccess implements Access {
    /**
     * List with the next pages which available for administrator.
     */
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
        stringList.add("/createPlaceQuest");
        stringList.add("/searchById");
        stringList.add("/searchByClientRole");
        stringList.add("/doManager");
        stringList.add("/updateQuest");
        stringList.add("/updateQuestInfo");
        stringList.add("/showOrders");
        stringList.add("/orderUserProfile");
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
