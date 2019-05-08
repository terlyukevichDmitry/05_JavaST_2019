package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.command.MessageManager;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RemovePersonAction implements ActionCommand {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(RemovePersonAction.class);

    private static final String PARAM_NAME_LOGIN = "login";
    @Override
    public String execute(HttpServletRequest request)
            throws ConstantException, ClassNotFoundException {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        if (login != null) {
            ServiceFactory factory = new ServiceFactoryImpl(
                    new SqlTransactionFactoryImpl());
            UserService service = factory.getService(UserService.class);
            User user = service.findByLogin(login);
            if (user != null) {
                service.delete(user.getId());
                request.getSession().setAttribute("errorLoginPassMessage",
                        MessageManager.getProperty("removeTrue"));
                return ConfigurationManager.getProperty("removeUser");
            } else {
                request.getSession().setAttribute("errorLoginPassMessage",
                        MessageManager.getProperty("loginErrr"));
                LOGGER.info(String.format("user \"%s\" unsuccessfully "
                                + "tried to log in from %s (%s:%s)", login,
                        request.getRemoteAddr(), request.getRemoteHost(),
                        request.getRemotePort()));
            }
        }
        return null;
    }
}
