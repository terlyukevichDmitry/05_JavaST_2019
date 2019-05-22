package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.factory.JspPage;

import javax.servlet.http.HttpServletRequest;

/**
 * This class we use for log out action.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class LogoutCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class it is
     * log out action.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     */
    @Override
    public JspPage execute(final HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        JspPage jspPage = new JspPage();
        jspPage.setPage("/logout");
        return jspPage;
    }
}
