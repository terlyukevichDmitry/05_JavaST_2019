package by.epam.site.action.logic;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("home");
        request.getSession().invalidate();
        return page;
    }
}