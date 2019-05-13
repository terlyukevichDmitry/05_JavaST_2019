package by.epam.site.action.factory;

import by.epam.site.action.admin.AcceptOrderCommand;
import by.epam.site.action.admin.PersonShowAction;
import by.epam.site.action.admin.UserProfileDirection;
import by.epam.site.action.command.*;
import by.epam.site.action.command.commandaction.*;
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
            this.command = new QuestShowCommand();
        }
    },
    MY_QUESTS("/myQuests") {
        {
            this.command = new MyQuestsDirection();
        }
    },
    GO_TO_PROFILE("/goToProfile") {
        {
            this.command = new UserProfileDirection();
        }
    },
    SHOW_REVIEW("/review") {
        {
            this.command = new ShowReviewCommand();
        }
    },
    SIGNUP("/signup") {
        {
            this.command = new SignUpDirection();
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
