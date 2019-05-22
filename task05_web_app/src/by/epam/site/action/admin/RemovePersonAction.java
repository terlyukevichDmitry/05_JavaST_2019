package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * This class we use for removing person.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class RemovePersonAction implements ActionCommand {

    /**
     * login parameter to removing person by username.
     */
    private static final String PARAM_NAME_LOGIN = "login";

    /**
     * Method in which we do action. In this class it is removing person
     * on our site.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     * @throws ClassNotFoundException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        jspPage.setTagName("errorLoginPassMessage");
        String login = request.getParameter(PARAM_NAME_LOGIN);
         if (login != null) {
            ServiceFactory factory = new ServiceFactoryImpl(
                    new SqlTransactionFactoryImpl());
            UserService service = factory.getService(UserService.class);
            User user = service.findByLogin(login);
            if (user != null) {
                service.delete(user.getId());
                ClientService clientService
                        = factory.getService(ClientService.class);
                clientService.delete(user.getId());
                request.getSession().setAttribute("textMessage",
                        MessageManager.getProperty("removeTrue"));
                jspPage.setPage(ConfigurationManager.getProperty("removeUser"));
                jspPage.setPage("/removeUser");
                factory.close();
                return jspPage;
            } else {
                request.getSession().setAttribute("textMessage",
                        MessageManager.getProperty("loginErrr"));
                jspPage.setPage("/removeUser?a=b");
                factory.close();
                return jspPage;
            }
        } else {
             jspPage.setPage(ConfigurationManager.getProperty("removeUser"));
             return jspPage;
         }
    }
}
