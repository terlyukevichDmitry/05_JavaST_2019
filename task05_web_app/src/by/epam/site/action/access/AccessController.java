package by.epam.site.action.access;

import by.epam.site.entity.Role;

public class AccessController {
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
