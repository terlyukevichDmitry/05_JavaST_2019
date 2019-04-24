package by.epam.site.action.loginout;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("home");
        request.getSession().invalidate();
        return page;
    }
}