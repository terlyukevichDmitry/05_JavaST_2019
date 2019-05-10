package by.epam.site.action.command;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Objects;

public class ChangePasswordAction implements ActionCommand {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ChangePasswordAction.class);
    @Override
    public String execute(HttpServletRequest request) throws ConstantException, SQLException, ClassNotFoundException {
        String password = request.getParameter("changePassword");
        String confirm = request.getParameter("changeConfirm");
        if (Objects.equals(password, confirm)
                && password.length() >= 4) {
            ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
            UserService service = factory.getService(UserService.class);
            User user = (User) request.getSession().getAttribute("user");
            user.setPassword(password);
            service.save(user);
            request.getSession().setAttribute("user", user);
            request.setAttribute("textMessage",
                    MessageManager.getProperty("completed"));
            LOGGER.info(String.format("user \"%s\" successfully "
                            + "changed in database %s (%s:%s)", password,
                    request.getRemoteAddr(), request.getRemoteHost(),
                    request.getRemotePort()));
        } else {
            request.setAttribute("textMessage",
                    MessageManager.getProperty("incorrectData"));
            LOGGER.info(String.format("user \"%s\" unsuccessfully "
                            + "tried to log in from %s (%s:%s)", password,
                    request.getRemoteAddr(), request.getRemoteHost(),
                    request.getRemotePort()));
        }
        return ConfigurationManager.getProperty("profilePath");
    }
}
