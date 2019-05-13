package by.epam.site.servlet;

import by.epam.site.action.Action;
import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ActionManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;

public class ControllerServlet extends HttpServlet {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ControllerServlet.class);
    @Override
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            ActionCommand actionCommand = new ActionManager().getPostCommand();
            JspPage jspPage = actionCommand.execute(request);
            if (jspPage.getPage().equals("/logout")) {
                response.sendRedirect(request.getContextPath()
                        + "/home");
                response.addHeader("Expires", "-1");
                response.addHeader("Pragma", "no-cache");
            } else {
                getServletContext().getRequestDispatcher(
                        jspPage.getPage()).forward(request, response);
            }
        } catch (ConstantException e) {
            LOGGER.warn("Constant exception");
        } catch (ServletException e) {
            LOGGER.warn("ServletException exception");
        } catch (SQLException e) {
            LOGGER.warn("SQLException exception");
        } catch (ParseException e) {
            LOGGER.warn("ParseException exception");
        } catch (UnsupportedEncodingException e) {
            LOGGER.warn("UnsupportedEncodingException exception");
        } catch (IOException e) {
            LOGGER.warn("IOException exception");
        } catch (ClassNotFoundException e) {
            LOGGER.warn("ClassNotFoundException exception");
        }
    }

    @Override
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            Action action = new Action();
            ActionCommand actionCommand
                    = new ActionManager().getActionCommand(action, request);
            JspPage jspPage = actionCommand.execute(request);
            response.sendRedirect(request.getContextPath()
                    + jspPage.getPage());
        } catch (ConstantException e) {
            LOGGER.warn("Constant exception");
        } catch (SQLException e) {
            LOGGER.warn("SQLException exception");
        } catch (ParseException e) {
            LOGGER.warn("ParseException exception");
        } catch (UnsupportedEncodingException e) {
            LOGGER.warn("UnsupportedEncodingException exception");
        } catch (IOException e) {
            LOGGER.warn("IOException exception");
        } catch (ClassNotFoundException e) {
            LOGGER.warn("ClassNotFoundException exception");
        }
    }
}
