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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * This class we use to log in on user account.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class LoginCommand implements ActionCommand {
    /**
     * Parameter with login information.
     */
    private static final String PARAM_NAME_LOGIN = "login";
    /**
     * Parameter with password information.
     */
    private static final String PARAM_NAME_PASSWORD = "password";
    /**
     * Method in which we do action. In this class it is
     * log in on user account.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     * @throws SQLException for checking exception situations.
     * @throws ClassNotFoundException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
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
                String encoded = jspPage.encode(
                        MessageManager.getProperty("loginerror"));
                jspPage.setPage("/login?message=" + encoded);
                request.getSession().setAttribute("errorLoginPassMessage",
                        MessageManager.getProperty("loginerror"));
            }
            factory.close();
            return jspPage;
        }
        return null;
    }
}
