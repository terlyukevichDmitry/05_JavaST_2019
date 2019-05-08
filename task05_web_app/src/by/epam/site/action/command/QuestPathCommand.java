package by.epam.site.action.command;

import javax.servlet.http.HttpServletRequest;

public class QuestPathCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty("questPath");
    }
}
