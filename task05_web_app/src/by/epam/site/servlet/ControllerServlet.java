package by.epam.site.servlet;

import by.epam.site.action.Action;
import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ActionManager;
import by.epam.site.action.factory.CommandEnum;
import by.epam.site.action.factory.PageEnum;
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
        request.setCharacterEncoding("UTF-8");

        Action action = new Action();
        ActionCommand actionCommand
                = new ActionManager().getActionCommand(action, request);
        String page = actionCommand.execute(request);
        String requestedUri = request.getRequestURI() + page;
        if (page != null) {
            String redirectedUri = request.getContextPath() + page;
            LOGGER.debug(String.format("Request for URI \"%s\" id redirected "
                    + "to URI \"%s\"", requestedUri, redirectedUri));
            response.sendRedirect(redirectedUri);
            //response.sendRedirect(redirectedUri);
            //            request.setAttribute("lst", list);
//            request.getRequestDispatcher("jsp/profile.jsp").forward(request, response);
//            request.getSession().setAttribute("hollo", "asdasd");
            //request.getRequestDispatcher(page).forward(request, response);
        } else {
            PageEnum pageEnum = PageEnum.getEnum(action.getForward());
            assert pageEnum != null;
            String jspPage = pageEnum.getValue();
            LOGGER.debug(String.format("Request for URI \"%s\" is forwarded "
                    + "to JSP \"%s\"", requestedUri, jspPage));
            getServletContext().getRequestDispatcher(jspPage).forward(request,
                    response);
//
//            page = ConfigurationManager.getProperty("home");
//            request.getSession().setAttribute("nullPage",
//                    MessageManager.getProperty("nullpage"));
//            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
