package by.epam.site.action.command.direction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;

import javax.servlet.http.HttpServletRequest;

/**
 * This class we use to get direction on different pages.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ChangeValueDirection implements ActionCommand {
    /**
     * Method in which we do action. In this class it is
     * getting direction on different pages.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     */
    @Override
    public JspPage execute(final HttpServletRequest request) {
        JspPage jspPage = new JspPage();
        jspPage.setPage(ConfigurationManager.getProperty("profilePath"));
        return jspPage;
    }
}
