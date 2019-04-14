package by.epam.site.servlet;

import by.epam.site.dao.AbstractDAO;
import by.epam.site.dao.UserDAO;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String signup = request.getParameter("signup");
        if (!username.equals("") && !password.equals("")) {
            if (checker(username, password)) {
                request.getRequestDispatcher(
                        "jsp/home.jsp").forward(request, response);
            }
        } else if(signup.equals("Sign Up")) {
            request.getRequestDispatcher("jsp/signUp.jsp").forward(request, response);
        }

    }

    private boolean checker(String username, String password) throws ConstantException, SQLException, ClassNotFoundException {
        AbstractDAO<User> abstractDAO = new UserDAO();
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
