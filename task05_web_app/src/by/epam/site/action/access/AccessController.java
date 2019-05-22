package by.epam.site.action.access;

import by.epam.site.entity.Role;

/**
 * This class we use for getting access for different users.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class AccessController {
    /**
     * Method to get access for user.
     * @param role access.
     * @return access opportunities.
     */
    public Access getAccess(final Role role) {
        Access access;
        switch (role) {
            case ADMINISTRATOR:
                access = new AdminAccess();
                break;
            case CLIENT:
                access = new ClientAccess();
                break;
                default: access = new UnauthorizedAccess();
        }
        return access;
    }
}
