package by.epam.site.servlet;

import by.epam.site.action.factory.ActionFactory;
import by.epam.site.action.loginout.ActionCommand;
import by.epam.site.action.loginout.ConfigurationManager;
import by.epam.site.action.loginout.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ControllerServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            processRequest(req, resp);
        } catch (ServletException | IOException ignored) { }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            processRequest(req, resp);
        } catch (ServletException | IOException ignored) { }
    }

    private void processRequest(final HttpServletRequest request,
                                final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String page = null;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        page = command.execute(request);
        if (page != null) {
            request.getRequestDispatcher(page).forward(request, response);
        } else {
            page = ConfigurationManager.getProperty("home");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
