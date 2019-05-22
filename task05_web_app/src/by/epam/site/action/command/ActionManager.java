package by.epam.site.action.command;

import by.epam.site.action.Action;

import javax.servlet.http.HttpServletRequest;

/**
 * This class we use to manipulate actions.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ActionManager {
    /**
     * Method to manipulate post actions.
     * @param action object.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return command action.
     */
    public ActionCommand getActionCommand(final Action action,
                                          final HttpServletRequest request) {
        return action.getActionFactory().defineActionCommand(action, request);
    }

    /**
     * Method to manipulate get actions.
     * @return command action.
     */
    public ActionCommand getPostCommand() {
        return new EmptyCommand();
    }
}
