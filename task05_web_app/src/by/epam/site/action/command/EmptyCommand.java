package by.epam.site.action.command;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty("signin");
    }
}