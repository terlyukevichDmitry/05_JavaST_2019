package by.epam.site.action.command;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class SignUpCommand implements ActionCommand {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(SignUpCommand.class);
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_CONFIRM_PASSWORD = "confirm";

    @Override
    public String execute(HttpServletRequest request)
            throws ConstantException, ClassNotFoundException {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String confirmPassword
                = request.getParameter(PARAM_NAME_CONFIRM_PASSWORD);
        if (login != null && password != null
                && Objects.equals(password, confirmPassword)
                && password.length() >= 4) {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setRole(Role.CLIENT);
            ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
            UserService service = factory.getService(UserService.class);
            service.save(user);
            request.setAttribute("textMessage",
                    MessageManager.getProperty("correctMessage"));
            LOGGER.info(String.format("user \"%s\" successfully "
                            + "added in database %s (%s:%s)", login,
                    request.getRemoteAddr(), request.getRemoteHost(),
                    request.getRemotePort()));
        } else {
            request.setAttribute("textMessage",
                    MessageManager.getProperty("incorrectData"));
            LOGGER.info(String.format("user \"%s\" unsuccessfully "
                            + "tried to log in from %s (%s:%s)", login,
                    request.getRemoteAddr(), request.getRemoteHost(),
                    request.getRemotePort()));
        }
        return null;
    }
}
