package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * This class we use to showing user profile.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ProfileCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class it is
     * showing user profile.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException {
        JspPage jspPage = new JspPage();

        String encode = request.getParameter("message");
        jspPage.getModel(jspPage, encode, request);

        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        ClientService service = factory.getService(ClientService.class);
        User user = (User) request.getSession().getAttribute("user");
        String message = request.getParameter("message");
        if (message == null) {
            request.getSession().setAttribute("errorPassword", "");
            request.getSession().setAttribute("changedParameters", "");
        }
        Client client = service.findById(user.getId());
        if (client.getFilePath().equals("nope")) {
            client.setFilePath("images/noPerson.jpg");
        }
        request.getSession().setAttribute("client", client);
        request.getSession().setAttribute("checker", true);
        factory.close();
        jspPage.setPage(
                ConfigurationManager.getProperty("profilePath"));
        return jspPage;
    }
}
