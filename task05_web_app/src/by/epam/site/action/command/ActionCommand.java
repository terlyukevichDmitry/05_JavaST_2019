package by.epam.site.action.command;

import by.epam.site.action.factory.JspPage;
import by.epam.site.exception.ConstantException;
import by.epam.site.exception.IncorrectDataException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Interface that we user to distributing action to other classes.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public interface ActionCommand {
    /**
     * Method in which we do action. In this class it is
     * distributing action to other classes.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     * @throws IncorrectDataException for checking exception situations.
     * @throws ServletException for checking exception situations.
     * @throws IOException for checking exception situations.
     * @throws ParseException for checking exception situations.
     * @throws ClassNotFoundException for checking exception situations.
     * @throws SQLException for checking exception situations.
     */
    JspPage execute(HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException,
            ParseException, IOException,
            ServletException, IncorrectDataException;
}
