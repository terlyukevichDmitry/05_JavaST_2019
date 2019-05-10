package by.epam.site.servlet;

import by.epam.site.action.Action;
import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ActionManager;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.CommandEnum;
import by.epam.site.action.factory.PageEnum;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("hha- it's a get method");
            processRequest(req, resp);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("hha- it's a post method");

            processRequest(req, resp);
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

    private void processRequest(final HttpServletRequest request,
                                final HttpServletResponse response)
            throws ServletException, IOException, ConstantException, SQLException, ClassNotFoundException, ParseException {
        request.setCharacterEncoding("UTF-8");
        Action action = new Action();
        ActionCommand actionCommand
                = new ActionManager().getActionCommand(action, request);
        String page = actionCommand.execute(request);
        String requestedUri = request.getRequestURI() + page;
        HttpSession session = request.getSession(false);
        if (session!= null) {
            if (page != null) {
                String redirectedUri = request.getContextPath() + page;
                LOGGER.debug(String.format("Request for URI \"%s\" id redirected "
                        + "to URI \"%s\"", requestedUri, redirectedUri));
                request.getRequestDispatcher(page).forward(request, response);
            } else {
                PageEnum pageEnum = PageEnum.getEnum(action.getForward());
                assert pageEnum != null;
                String jspPage = pageEnum.getValue();
                LOGGER.debug(String.format("Request for URI \"%s\" is forwarded "
                        + "to JSP \"%s\"", requestedUri, jspPage));
                request.getRequestDispatcher(jspPage).forward(request,
                        response);
            }
        } else {
            String redirecred = request.getContextPath() + ConfigurationManager.getProperty("home");
            response.addHeader("Expires","-1");
            response.addHeader("Pragma","no-cache");
            response.sendRedirect(redirecred);

//            request.getRequestDispatcher(ConfigurationManager.getProperty("home")).include(request, response);
        }
    }
}
