package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(LoginCommand.class);
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        if (login != null && password != null) {
            ServiceFactory factory = new ServiceFactoryImpl(
                    new SqlTransactionFactoryImpl());
            UserService service = factory.getService(UserService.class);
            User user = service.findByLoginAndPassword(login, password);
            if (user != null) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("user", user);
                jspPage.setPage("/home");
            } else {
                jspPage.setPage("/login?a=b");
                request.getSession().setAttribute("errorLoginPassMessage",
                        MessageManager.getProperty("loginerror"));
            }
            return jspPage;
        }
        return null;
    }
}
