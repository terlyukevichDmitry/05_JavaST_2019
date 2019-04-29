package by.epam.site.action.loginout;

import by.epam.site.exception.ConstantException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        try {
            if (LoginLogic.checkLogin(login, pass)) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("user", login);
                page = ConfigurationManager.getProperty("home");
            } else {
                request.setAttribute("errorLoginPassMessage",
                        MessageManager.getProperty("loginerror"));
                page = ConfigurationManager.getProperty("signin");
            }
        } catch (ConstantException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return page;
    }
}
