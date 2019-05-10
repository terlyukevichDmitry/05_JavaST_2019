package by.epam.site.action.command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        request.getSession().setMaxInactiveInterval(1);
        request.getSession().invalidate();
        return ConfigurationManager.getProperty("home");
    }
}