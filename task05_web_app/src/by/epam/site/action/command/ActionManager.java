package by.epam.site.action.command;

import by.epam.site.action.Action;

import javax.servlet.http.HttpServletRequest;

public class ActionManager {
    public ActionCommand getActionCommand(final Action action,
                                           final HttpServletRequest request) {
        return action.getActionFactory().defineCommand(action, request);
    }
}
