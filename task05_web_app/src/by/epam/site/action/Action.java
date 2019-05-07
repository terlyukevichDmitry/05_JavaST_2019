package by.epam.site.action;

import by.epam.site.action.factory.ActionFactory;

public class Action {
    private String forward;
    private ActionFactory actionFactory;

    public Action() {
        actionFactory = new ActionFactory();
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public ActionFactory getActionFactory() {
        return actionFactory;
    }

    public void setActionFactory(ActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }
}
