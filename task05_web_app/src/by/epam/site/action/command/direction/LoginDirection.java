package by.epam.site.action.command.direction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;

import javax.servlet.http.HttpServletRequest;

public class LoginDirection implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) {
        JspPage jspPage = new JspPage();
        String encoded = request.getParameter("message");
        if (encoded == null) {
            request.getSession().setAttribute(
                    "errorLoginPassMessage", "");
            request.getSession().setAttribute("notAccess", "");
        }
        jspPage.setPage(ConfigurationManager.getProperty("signin"));
        return jspPage;
    }
}
