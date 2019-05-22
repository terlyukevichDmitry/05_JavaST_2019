package by.epam.site.action.command.direction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;

import javax.servlet.http.HttpServletRequest;

/**
 * This class we use to get direction on login page.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class LoginDirection implements ActionCommand {
    /**
     * Method in which we do action. In this class it is
     * getting direction on login page.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     */
    @Override
    public JspPage execute(final HttpServletRequest request) {
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
