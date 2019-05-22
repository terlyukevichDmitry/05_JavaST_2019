package by.epam.site.action.command.direction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.exception.ConstantException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * This class we use to get direction on different pages.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ShowPersonByParameterCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class it is
     * getting direction on different pages.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     * @throws ClassNotFoundException for checking exception situations.
     * @throws SQLException for checking exception situations.
     * @throws IOException for checking exception situations.
     * @throws ParseException for checking exception situations.
     * @throws ServletException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException,
            SQLException, ClassNotFoundException,
            ParseException, IOException, ServletException {
        JspPage jspPage = new JspPage();
        jspPage.setPage(ConfigurationManager.getProperty("showUsers"));
        return jspPage;
    }
}
