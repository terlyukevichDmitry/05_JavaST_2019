package by.epam.site.servlet;

import by.epam.site.action.factory.ActionFactory;
import by.epam.site.action.logic.ActionCommand;
import by.epam.site.action.logic.ConfigurationManager;
import by.epam.site.action.logic.MessageManager;
import by.epam.site.dao.daoimpl.AbstractDAOImpl;
import by.epam.site.dao.daoimpl.UserDAOImpl;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (ConstantException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (ConstantException e) {
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

        page = command.execute(request);
        if (page != null) {
            request.getRequestDispatcher(page).forward(request, response);
        } else {
            page = ConfigurationManager.getProperty("home");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        if (!username.equals("") && !password.equals("") && checker(username, password)) {
//            request.getRequestDispatcher(
//                    "jsp/home.jsp").forward(request, response);
//        }
    }

    private boolean checker(String username, String password) throws ConstantException, SQLException, ClassNotFoundException {
        AbstractDAOImpl<User> abstractDAO = new UserDAOImpl();
        List<User> userList = abstractDAO.readAll();
        for (User user :userList) {
            if (!username.equals(user.getLogin()) || !password.equals(user.getPassword())) {
                continue;
            }
            return true;
        }
        return false;
    }
}
