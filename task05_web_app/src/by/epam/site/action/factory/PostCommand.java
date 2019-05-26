package by.epam.site.action.factory;

import by.epam.site.action.admin.*;
import by.epam.site.action.command.commandaction.*;
import by.epam.site.action.command.*;

/**
 * Enum to manipulate actions.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public enum PostCommand {
    /**
     * Login.
     */
    LOGIN("/login") {
        {
            this.command = new LoginCommand();
        }
    },
    /**
     * CHANGE_VALUE.
     */
    CHANGE_VALUE("/changeValue") {
        {
            this.command = new ChangeParameterAction();
        }
    },
    /**
     * CHANGE_PASSWORD.
     */
    CHANGE_PASSWORD("/changePassword") {
        {
            this.command = new ChangePasswordAction();
        }
    },
    /**
     * REMOVE.
     */
    REMOVE("/removeUser") {
        {
            this.command = new RemovePersonAction();
        }
    },
    /**
     * SEARCH_BY_PARAMETER.
     */
    SEARCH_BY_PARAMETER("/searchByParameter") {
        {
            this.command = new SearchByNameCommand();
        }
    },
    /**
     * BOOK_QUEST.
     */
    BOOK_QUEST("/bookQuest") {
        {
            this.command = new BookQuestCommand();
        }
    },
    /**
     * REMOVE_ORDER.
     */
    REMOVE_ORDER("/removeOrder") {
        {
            this.command = new RemoveOrderCommand();
        }
    },
    /**
     * GO_TO_USER_PROFILE.
     */
    GO_TO_USER_PROFILE("/goToProfile") {
        {
            this.command = new UserProfileDirection();
        }
    },
    /**
     * DENY_ORDER.
     */
    DENY_ORDER("/deny") {
        {
            this.command = new DenyOrderCommand();
        }
    },
    /**
     * ACCEPT_ORDER.
     */
    ACCEPT_ORDER("/acceptOrder") {
        {
            this.command = new AcceptOrderCommand();
        }
    },
    /**
     * REMOVE_PERSON.
     */
    REMOVE_PERSON("/removePerson") {
        {
            this.command = new RemovePersonCommand();
        }
    },
    /**
     * DO_MANAGER.
     */
    DO_MANAGER("/doManager") {
        {
            this.command = new ChangePersonAccessCommand();
        }
    },
    /**
     * ADD_REVIEW.
     */
    ADD_REVIEW("/addReview") {
        {
            this.command = new AddReviewCommand();
        }
    },
    /**
     * SEARCH_BY_ID.
     */
    SEARCH_BY_ID("/searchById") {
        {
            this.command = new SearchByIdCommand();
        }
    },
    /**
     * SEARCH_BY_CLIENT_ROLE.
     */
    SEARCH_BY_CLIENT_ROLE("/searchByClientRole") {
        {
            this.command = new SearchByClientRoleCommand();
        }
    },
    /**
     * REMOVE_REVIEW.
     */
    REMOVE_REVIEW("/removeReview") {
        {
            this.command = new RemoveReviewCommand();
        }
    },
    /**
     * CREATE_QUEST.
     */
    CREATE_QUEST("/createNewQuest") {
        {
            this.command = new CreateQuestCommand();
        }
    },
    /**
     * CREATE_PLACE.
     */
    CREATE_PLACE("/createPlaceQuest") {
        {
            this.command = new CreateQuestPlaceCommand();
        }
    },
    /**
     * REMOVE_BY_ADMIN.
     */
    REMOVE_BY_ADMIN("/removeOrderByAdmin") {
        {
            this.command = new RemoveOrderByAdminCommand();
        }
    },
    /**
     * CHANGE_PHOTO.
     */
    CHANGE_PHOTO("/changePhoto") {
        {
            this.command = new ChangePhotoCommand();
        }
    },
    /**
     * REMOVE_QUEST.
     */
    REMOVE_QUEST("/removeQuest") {
        {
            this.command = new RemoveQuestCommand();
        }
    },
    /**
     * UPDATE_QUEST.
     */
    UPDATE_QUEST("/updateQuestInfo") {
        {
            this.command = new UpdateQuestCommand();
        }
    },
    /**
     * SIGNUP.
     */
    SIGNUP("/signup") {
        {
            this.command = new CreatePersonCommand();
        }
    };

    /**
     * Name for key.
     */
    private String name;
    /**
     * Action to do next.
     */
    ActionCommand command;
    /**
     * ActionCommand.
     * @return command.
     */
    public ActionCommand getCurrentCommand() {
        return command;
    }

    /**
     * Constructor.
     * @param value key.
     */
    PostCommand(final String value) {
        this.name = value;
    }

    /**
     * Method to getting enum value.
     * @param string key to find.
     * @return command.
     */
    public static PostCommand getEnum(final String string) {
        for (PostCommand c: PostCommand.values()) {
            if (c.name.equals(string)) {
                return c;
            }
        }
        return null;
    }
}
