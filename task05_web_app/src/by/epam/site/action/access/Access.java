package by.epam.site.action.access;

/**
 * Interface which have only one method
 * that checking access for different users.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public interface Access {
    /**
     * Method for checking access for administrator.
     * @param checkString name of page.
     * @return result, available or not.
     */
    boolean checkAccess(String checkString);
}
