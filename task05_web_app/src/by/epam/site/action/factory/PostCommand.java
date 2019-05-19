package by.epam.site.action.factory;

import by.epam.site.action.admin.*;
import by.epam.site.action.command.commandaction.*;
import by.epam.site.action.command.*;

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
            this.command = new SearchByNameCommand();
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
    DO_ADMIN("/doManager") {
        {
            this.command = new ChangePersonAccessCommand();
        }
    },
    ADD_REVIEW("/addReview") {
        {
            this.command = new AddReviewCommand();
        }
    },
    SEARCH_BY_ID("/searchById") {
        {
            this.command = new SearchByIdCommand();
        }
    },
    SEARCH_BY_CLIENT_ROLE("/searchByClientRole") {
        {
            this.command = new SearchByClientRoleCommand();
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

    CREATE_PLACE("/createPlaceQuest") {
        {
            this.command = new CreateQuestPlaceCommand();
        }
    },
    CHANGE_PHOTO("/changePhoto") {
        {
            this.command = new ChangePhotoCommand();
        }
    },
    REMOVE_QUEST("/removeQuest") {
        {
            this.command = new RemoveQuestCommand();
        }
    },
    UPDATE_QUEST("/updateQuestInfo") {
        {
            this.command = new UpDateQuestCommand();
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
