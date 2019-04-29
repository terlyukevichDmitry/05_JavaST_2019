package by.epam.site.servlet;

import by.epam.site.action.factory.ActionFactory;
import by.epam.site.action.login.ActionCommand;
import by.epam.site.action.login.ConfigurationManager;
import by.epam.site.action.login.MessageManager;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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
        } catch (ServletException | IOException ignored) { } catch (ConstantException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            processRequest(req, resp);
        } catch (ServletException | IOException ignored) { } catch (ConstantException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(final HttpServletRequest request,
                                final HttpServletResponse response)
            throws ServletException, IOException, ConstantException, SQLException, ClassNotFoundException {
        response.setContentType("text/html");
        String page = null;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

//        AbstractDAOImpl<Image> abstractDAO = new ImageDAOImpl();
//        List<Image> list = abstractDAO.readAll();
        page = command.execute(request);
        if (page != null) {
//            request.setAttribute("lst", list);
//            request.getRequestDispatcher("jsp/profile.jsp").forward(request, response);
            request.getSession().setAttribute("hollo", "asdasd");
            request.getRequestDispatcher(page).forward(request, response);
        } else {
            page = ConfigurationManager.getProperty("home");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
