package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.exception.ConstantException;
import by.epam.site.exception.IncorrectDataException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * This class we use for showing all orders different users.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ShowUserOrderProfileCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class
     * it is showing all orders different users.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     * @throws SQLException for checking exception situations.
     * @throws ClassNotFoundException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException,
            ParseException, IOException, ServletException,
            IncorrectDataException {
        JspPage jspPage = new JspPage();

        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        ClientService service = factory.getService(ClientService.class);
        String clientId = request.getParameter("clientId");
        if (clientId == null) {
            clientId = String.valueOf(request.getSession().getAttribute(
                    "clientIdInformation"));
        } else {
            request.getSession().setAttribute("clientIdInformation",
                    clientId);
        }
        String message = request.getParameter("message");
        if (message == null) {
            request.getSession().setAttribute("errorPassword", "");
            request.getSession().setAttribute("changedParameters", "");
        }

        request.getSession().setAttribute("client",
                service.findById(Integer.parseInt(clientId)));
        request.getSession().setAttribute("checker", false);
        factory.close();
        jspPage.setPage(
                ConfigurationManager.getProperty("profilePath"));
        return jspPage;
    }
}
