package by.epam.site.servlet;

import by.epam.site.action.factory.ActionFactory;
import by.epam.site.action.loginout.ActionCommand;
import by.epam.site.action.loginout.ConfigurationManager;
import by.epam.site.action.loginout.MessageManager;
import by.epam.site.dao.daoimpl.AbstractDAOImpl;
import by.epam.site.dao.daoimpl.ImageDAOImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.Image;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

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
//            request.getRequestDispatcher("jsp/contact.jsp").forward(request, response);
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
