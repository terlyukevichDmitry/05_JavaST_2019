package by.epam.site.servlet;

import by.epam.site.action.Action;
import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ActionManager;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class ControllerServlet extends HttpServlet {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ControllerServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
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
        } catch (ServletException | IOException ignored) { } catch (ConstantException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) {
        try {
            Action action = new Action();
            ActionCommand actionCommand
                    = new ActionManager().getActionCommand(action, request);
            JspPage jspPage = actionCommand.execute(request);
            response.sendRedirect(request.getContextPath()
                    + jspPage.getPage());
        } catch (IOException ignored) { } catch (ConstantException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
