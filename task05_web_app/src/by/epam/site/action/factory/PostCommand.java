package by.epam.site.action.factory;

import by.epam.site.action.admin.RemoveOrderByAdminCommand;
import by.epam.site.action.admin.RemovePersonAction;
import by.epam.site.action.admin.UserProfileDirection;
import by.epam.site.action.command.commandaction.*;
import by.epam.site.action.command.*;
import by.epam.site.action.command.direction.UserProfilePathCommand;

public enum PostCommand {

    LOGIN("/login") {
        {
            this.command = new LoginCommand();
        }
    },
    CHANGE_VALUE("/changeValue") {
        {
            this.command = new ChangeParameterAction();
        }
    },
    CHANGE_PASSWORD("/changePassword") {
        {
            this.command = new ChangePasswordAction();
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
    BOOK_QUEST("/bookQuest") {
        {
            this.command = new BookQuestCommand();
        }
    },
    REMOVE_ORDER("/removeOrder") {
        {
            this.command = new RemoveOrderCommand();
        }
    },
    GO_TO_USER_PROFILE("/goToProfile") {
        {
            this.command = new UserProfileDirection();
        }
    },
    REMOVE_BY_ADMIN("/removeOrderByAdmin") {
        {
            this.command = new RemoveOrderByAdminCommand();
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

    PostCommand(String name) {
        this.name = name;
    }

    public static PostCommand getEnum(final String string) {
        for (PostCommand c: PostCommand.values()) {
            if (c.name.equals(string)) {
                return c;
            }
        }
        return null;
    }
}
