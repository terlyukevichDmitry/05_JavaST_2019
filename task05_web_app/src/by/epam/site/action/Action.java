package by.epam.site.action;

import by.epam.site.action.factory.ActionFactory;

public class Action {
    private String forward;
    private ActionFactory actionFactory;

    public Action() {
        actionFactory = new ActionFactory();
    }


    public void setForward(String forward) {
        this.forward = forward;
    }

    public ActionFactory getActionFactory() {
        return actionFactory;
    }

}
