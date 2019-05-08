package by.epam.site.action.factory;

import by.epam.site.action.command.*;

public enum PageEnum {
    SIGNIN("/login") {
        {
            value = ConfigurationManager.getProperty("signin");
        }
    },
    REMOVE("/removeUser") {
        {
            value = ConfigurationManager.getProperty("removeUser");
        }
    },
    SIGNUP("/signup") {
        {
            value = ConfigurationManager.getProperty("signUp");
        }
    };

    String name;
    String value;

    PageEnum(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public static PageEnum getEnum(final String string) {
        for (PageEnum pageEnum: PageEnum.values()) {
            if (pageEnum.name.equals(string)) {
                return pageEnum;
            }
        }
        return null;
    }
}
