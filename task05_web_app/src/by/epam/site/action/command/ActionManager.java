package by.epam.site.action.command;

import by.epam.site.action.Action;
import by.epam.site.action.command.commandaction.EmptyCommand;

import javax.servlet.http.HttpServletRequest;

public class ActionManager {
    public ActionCommand getActionCommand(final Action action,
                                          final HttpServletRequest request) {
        return action.getActionFactory().defineActionCommand(action, request);
    }
    public ActionCommand getPostCommand() {
        return new EmptyCommand();
    }
}
