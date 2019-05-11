package by.epam.site.action.factory;

import by.epam.site.action.admin.PersonShowAction;
import by.epam.site.action.command.*;
import by.epam.site.action.command.commandaction.CreatePersonCommand;
import by.epam.site.action.command.commandaction.LogoutCommand;
import by.epam.site.action.command.commandaction.ProfileCommand;
import by.epam.site.action.command.commandaction.QuestsCommand;
import by.epam.site.action.command.direction.*;

public enum GetCommand {
    LOGIN("/login") {
        {
            this.command = new LoginDirection();
        }
    },
    CHANGE_VALUE("/changeValue") {
        {
            this.command = new ChangeValueDirection();
        }
    },
    CHANGE_PASSWORD("/changePassword") {
        {
            this.command = new ChangePasswordDirection();
        }
    },
    REMOVE("/removeUser") {
        {
            this.command = new RemovePersonDirection();
        }
    },
    SEARCH_BY_PARAMETER("/searchByParameter") {
        {
            this.command = new SearchByParameterDirection();
        }
    },
    LOGOUT("/logout") {
        {
            this.command = new LogoutCommand();
        }
    },
    HOME("/home") {
        {
            this.command = new HomeDirection();
        }
    },
    PROFILE("/profile") {
        {
            this.command = new ProfileCommand();
        }
    },
    SHOW_USERS("/showUsers") {
        {
            this.command = new PersonShowAction();
        }
    },
    QUEST_PLACES_PATH("/quests") {
        {
            this.command = new QuestsCommand();
        }
    },
    SIGNUP("/signup") {
        {
            this.command = new CreatePersonCommand();
        }
    };
    String name;

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }

    GetCommand(String name) {
        this.name = name;
    }

    public static GetCommand getEnum(final String string) {
        for (GetCommand c: GetCommand.values()) {
            if (c.name.equals(string)) {
                return c;
            }
        }
        return null;
    }
}
