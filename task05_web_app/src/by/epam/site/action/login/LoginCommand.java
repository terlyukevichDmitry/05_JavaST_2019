package by.epam.site.action.login;

import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.serviceimpl.UserServiceImpl;
import by.epam.site.teg.InfoTimeTag;

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
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        UserServiceImpl service = new UserServiceImpl();
        try {
            User user = service.findByLoginAndPassword(login, password);
            if (user != null) {
                InfoTimeTag timeTag = new InfoTimeTag();
                timeTag.setRole(user.getRole().getName());
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("user", login);
                request.setAttribute("user", "administrator");
                //in this position i should tell page to open menu for different role!!!!
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
