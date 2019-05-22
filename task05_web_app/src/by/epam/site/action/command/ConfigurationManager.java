package by.epam.site.action.command;

import java.util.ResourceBundle;

/**
 * This class we use to manipulate resource bundle.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ConfigurationManager {
    /**
     * Resource bundle.
     */
    private final static ResourceBundle resourceBundle
            = ResourceBundle.getBundle("config");

    /**
     * Constructor.
     */
    private ConfigurationManager() {
    }

    /**
     * Method for getting resource bundle value.
     * @param key to getting value of bundle.
     * @return message of bundle.
     */
    public static String getProperty(final String key) {
        return resourceBundle.getString(key);
    }
}
