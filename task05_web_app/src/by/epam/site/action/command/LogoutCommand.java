package by.epam.site.action.command;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("user", "");
        request.getSession(false).invalidate();
        return ConfigurationManager.getProperty("home");
    }
}