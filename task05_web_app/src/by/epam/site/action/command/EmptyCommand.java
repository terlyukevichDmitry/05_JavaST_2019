package by.epam.site.action.command;

import by.epam.site.action.factory.GetCommand;
import by.epam.site.action.factory.JspPage;
import by.epam.site.exception.ConstantException;
import by.epam.site.exception.IncorrectDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * This class we use to manipulate actions.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class EmptyCommand implements ActionCommand {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(EmptyCommand.class);
    /**
     * Method to manipulate get actions.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jsp page.
     */
    @Override
    public JspPage execute(final HttpServletRequest request) {
        JspPage jspPage = new JspPage();
        String actionValue = String.valueOf(request.getAttribute("action"));
        try {
            GetCommand currentEnum = GetCommand.getEnum(actionValue);
            assert currentEnum != null;
            ActionCommand current = currentEnum.getCurrentCommand();
            jspPage = current.execute(request);
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", actionValue
                    + MessageManager.getProperty("wrongaction"));
        } catch (ConstantException e) {
            LOGGER.warn("ConstantException", e);
        } catch (ParseException e) {
            LOGGER.warn("ParseException", e);
        } catch (SQLException e) {
            LOGGER.warn("SQLException", e);
        } catch (ClassNotFoundException e) {
            LOGGER.warn("ClassNotFoundException", e);
        } catch (ServletException e) {
            LOGGER.warn("ServletException", e);
        } catch (IOException e) {
            LOGGER.warn("IOException", e);
        } catch (IncorrectDataException e) {
            LOGGER.warn("IncorrectDataException", e);
        }
        return jspPage;
    }
}
