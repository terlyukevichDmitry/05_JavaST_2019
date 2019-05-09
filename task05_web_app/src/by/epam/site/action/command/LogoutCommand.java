package by.epam.site.action.command;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.entity.User;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("user", new User());
        request.getSession(false).invalidate();
        return ConfigurationManager.getProperty("home");
    }
}