package by.epam.site.action.factory;

import by.epam.site.action.admin.*;
import by.epam.site.action.command.*;
import by.epam.site.action.command.commandaction.*;
import by.epam.site.action.command.direction.*;

/**
 * Enum to manipulate actions.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public enum GetCommand {
    /**
     * Login.
     */
    LOGIN("/login") {
        {
            this.command = new LoginDirection();
        }
    },
    /**
     * CHANGE_VALUE.
     */
    CHANGE_VALUE("/changeValue") {
        {
            this.command = new ChangeValueDirection();
        }
    },
    /**
     * CHANGE_PASSWORD.
     */
    CHANGE_PASSWORD("/changePassword") {
        {
            this.command = new ChangePasswordDirection();
        }
    },
    /**
     * REMOVE.
     */
    REMOVE("/removeUser") {
        {
            this.command = new RemovePersonDirection();
        }
    },
    /**
     * SEARCH_BY_PARAMETER.
     */
    SEARCH_BY_PARAMETER("/searchByParameter") {
        {
            this.command = new SearchByParameterDirection();
        }
    },
    /**
     * LOGOUT.
     */
    LOGOUT("/logout") {
        {
            this.command = new LogoutCommand();
        }
    },
    /**
     * HOME.
     */
    HOME("/home") {
        {
            this.command = new HomeDirection();
        }
    },
    /**
     * PROFILE.
     */
    PROFILE("/profile") {
        {
            this.command = new ProfileCommand();
        }
    },
    /**
     * SHOW_USERS.
     */
    SHOW_USERS("/showUsers") {
        {
            this.command = new PersonShowAction();
        }
    },
    /**
     * SEARCH_BY_ID.
     */
    SEARCH_BY_ID("/searchById") {
        {
            this.command = new ShowPersonByParameterCommand();
        }
    },
    /**
     * DO_MANAGER.
     */
    DO_ADMIN("/doManager") {
        {
            this.command = new ChangeAccessDirection();
        }
    },
    /**
     * SEARCH_BY_CLIENT_ROLE.
     */
    SEARCH_BY_CLIENT_ROLE("/searchByClientRole") {
        {
            this.command = new ShowPersonByParameterCommand();
        }
    },
    /**
     * QUEST_PLACES_PATH.
     */
    QUEST_PLACES_PATH("/quests") {
        {
            this.command = new QuestShowCommand();
        }
    },
    /**
     * MY_QUESTS.
     */
    MY_QUESTS("/myQuests") {
        {
            this.command = new MyQuestsDirection();
        }
    },
    /**
     * GO_TO_PROFILE.
     */
    GO_TO_PROFILE("/goToProfile") {
        {
            this.command = new UserProfileDirection();
        }
    },
    /**
     * QUEST_INFORMATION.
     */
    QUEST_INFORMATION("/questInformation") {
        {
            this.command = new ShowQuestInformationCommand();
        }
    },
    /**
     * SHOW_REVIEW.
     */
    SHOW_REVIEW("/review") {
        {
            this.command = new ShowReviewCommand();
        }
    },
    /**
     * CREATE_QUEST.
     */
    CREATE_QUEST("/createQuest") {
        {
            this.command = new CreateQuestDirection();
        }
    },
    /**
     * ORDER_PROFILE.
     */
    ORDER_PROFILE("/orderUserProfile") {
        {
            this.command = new ShowUserOrderProfileCommand();
        }
    },
    /**
     * SHOW_ORDERS.
     */
    SHOW_ORDERS("/showOrders") {
        {
            this.command = new ShowAllOrdersCommand();
        }
    },
    /**
     * UPDATE_QUEST.
     */
    UPDATE_QUEST("/updateQuest") {
        {
            this.command = new UpdateQuestDirection();
        }
    },
    /**
     * SIGNUP.
     */
    SIGNUP("/signup") {
        {
            this.command = new SignUpDirection();
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
    GetCommand(final String value) {
        this.name = value;
    }

    /**
     * Method to getting enum value.
     * @param string key to find.
     * @return command.
     */
    public static GetCommand getEnum(final String string) {
        for (GetCommand command: GetCommand.values()) {
            if (command.name.equals(string)) {
                return command;
            }
        }
        return null;
    }
}
