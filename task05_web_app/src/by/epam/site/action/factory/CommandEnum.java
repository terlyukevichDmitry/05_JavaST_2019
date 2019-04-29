package by.epam.site.action.factory;

import by.epam.site.action.login.ActionCommand;
import by.epam.site.action.login.LoginCommand;
import by.epam.site.action.loginout.LogoutCommand;
import by.epam.site.action.signup.SignUpCommand;

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
    },
    SIGNUP {
        {
            this.command = new SignUpCommand();
        }
    };

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
