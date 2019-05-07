package by.epam.site.action.factory;

import by.epam.site.action.command.*;

public enum CommandEnum {
    LOGIN("/login") {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT("/logout") {
        {
            this.command = new LogoutCommand();
        }
    },
    HOME("/home") {
        {
            this.command = new HomeCommand();
        }
    },
    SIGNIN("/signIn") {
        {
            this.command = new SignInPathCommand();
        }
    },
    SIGNUP_PATH("/signupPath") {
        {
            this.command = new SignUpPathCommand();
        }
    },
    SIGNUP("/signup") {
        {
            this.command = new SignUpCommand();
        }
    };

    String name;

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }

    CommandEnum(String name) {
        this.name = name;
    }

    public static CommandEnum getEnum(final String string) {
        for (CommandEnum c: CommandEnum.values()) {
            if (c.name.equals(string)) {
                return c;
            }
        }
        return null;
    }
}
