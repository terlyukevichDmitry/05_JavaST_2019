package by.epam.site.action.factory;

import by.epam.site.action.Action;
import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.EmptyCommand;
import by.epam.site.action.command.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * This class we use to manipulate actions.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ActionFactory {
    /**
     * Method to manipulate post actions.
     * @param action object.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return command action.
     */
    public ActionCommand defineActionCommand(final Action action,
                                             final HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String actionValue = String.valueOf(request.getAttribute("action"));
        action.setForward(actionValue);
        if (actionValue == null || actionValue.isEmpty()) {
            return current;
        }
        try {
            PostCommand currentEnum = PostCommand.getEnum(actionValue);
            assert currentEnum != null;
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", actionValue
                    + MessageManager.getProperty("wrongaction"));
        }
        return current;
    }
}
