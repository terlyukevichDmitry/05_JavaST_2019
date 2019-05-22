package by.epam.site.action.command.direction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.exception.ConstantException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * This class we use to get direction on sign up page.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class SignUpDirection implements ActionCommand {
    /**
     * Method in which we do action. In this class it is
     * getting direction on sign up page.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException, SQLException,
            ClassNotFoundException, ParseException {
        JspPage jspPage = new JspPage();
        String encoded = request.getParameter("message");
        if (encoded == null) {
            request.getSession().setAttribute("errorInfo", "");
        }
        jspPage.setPage(ConfigurationManager.getProperty("signUp"));
        return jspPage;
    }
}
