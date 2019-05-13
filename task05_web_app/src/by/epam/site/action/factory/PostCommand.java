package by.epam.site.action.factory;

import by.epam.site.action.admin.*;
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
    DENY_ORDER("/deny") {
        {
            this.command = new DenyOrderCommand();
        }
    },
    ACCEPT_ORDER("/acceptOrder") {
        {
            this.command = new AcceptOrderCommand();
        }
    },
    REMOVE_BY_ADMIN("/removeOrderByAdmin") {
        {
            this.command = new RemoveOrderByAdminCommand();
        }
    },
    REMOVE_PERSON("/removePerson") {
        {
            this.command = new RemovePersonCommand();
        }
    },
    ADD_REVIEW("/addReview") {
        {
            this.command = new AddReviewCommand();
        }
    },
    REMOVE_REVIEW("/removeReview") {
        {
            this.command = new RemoveReviewCommand();
        }
    },
    CREATE_QUEST("/createNewQuest") {
        {
            this.command = new CreateQuestCommand();
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
