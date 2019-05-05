package by.epam.site.action.login;

import by.epam.site.action.calculator.Cl;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import by.epam.site.service.serviceimpl.UserServiceImpl;
import by.epam.site.teg.InfoTimeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LoginCommand extends Cl implements ActionCommand{
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        try {
            ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
            UserService service = factory.getService(UserService.class);
            User user = service.findByLoginAndPassword(login, password);
            if (user != null) {
                InfoTimeTag timeTag = new InfoTimeTag();
                timeTag.setRole(user.getRole().getName());
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("user", login);
                request.setAttribute("user", "administrator");
                //in this position i should tell page to open menu fo different role!!!!
                page = ConfigurationManager.getProperty("home");
            } else {
                request.setAttribute("errorLoginPassMessage",
                        MessageManager.getProperty("loginerror"));
                page = ConfigurationManager.getProperty("signin");
            }
        } catch (ConstantException  e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return page;
    }
}
