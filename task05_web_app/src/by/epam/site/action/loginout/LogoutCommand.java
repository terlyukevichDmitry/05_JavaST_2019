package by.epam.site.action.loginout;

import by.epam.site.action.login.ActionCommand;
import by.epam.site.action.login.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("home");
        request.getSession(false).invalidate();
        return page;
    }
}