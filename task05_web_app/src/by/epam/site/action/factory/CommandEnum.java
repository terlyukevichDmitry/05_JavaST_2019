package by.epam.site.action.factory;

import by.epam.site.action.admin.PersonShowAction;
import by.epam.site.action.admin.RemovePersonAction;
import by.epam.site.action.admin.RemovePersonPathCommand;
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
    SHOW_USERS("/showUsers") {
        {
            this.command = new PersonShowAction();
        }
    },
    REMOVE("/removeUser") {
        {
            this.command = new RemovePersonAction();
        }
    },
    SEARCH_BY_PARAMETER("/searchByParameter") {
        {
            this.command = new SearchByParameterCommand();
        }
    },
    QUEST_PLACES_PATH("/questPlaces") {
        {
            this.command = new QuestPlaceCommand();
        }
    },
    REMOVE_PATH("/removePath") {
        {
            this.command = new RemovePersonPathCommand();
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
