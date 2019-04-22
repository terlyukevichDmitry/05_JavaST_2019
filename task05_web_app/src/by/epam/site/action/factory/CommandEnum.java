package by.epam.site.action.factory;

import by.epam.site.action.logic.ActionCommand;
import by.epam.site.action.logic.LoginCommand;
import by.epam.site.action.logic.LogoutCommand;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
