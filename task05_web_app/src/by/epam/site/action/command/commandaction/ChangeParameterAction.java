package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * This class we use for changing information about person.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ChangeParameterAction implements ActionCommand {
    /**
     * Method in which we do action. In this class it is
     * changing information about person.
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
        String name = request.getParameter("changeName");
        String surname = request.getParameter("changeSurname");
        String patronymic = request.getParameter("changePatronymic");
        String dateOfBirth = request.getParameter("changeDateOfBirth");
        String phone = request.getParameter("changePhone");
        String email = request.getParameter("changeEmail");
        User user = (User) request.getSession().getAttribute("user");

        JspPage jspPage = new JspPage();

        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        ClientService service = factory.getService(ClientService.class);
        Client client = service.findById(user.getId());
        if (phone != null && !("").equals(phone)) {
            client.setPhone(phone);
        }
        if (!("").equals(email)) {
            client.setEmail(email);
        }
        if (!("").equals(patronymic)) {
            client.setPatronymic(patronymic);
        }
        if (!("").equals(surname)) {
            client.setSurname(surname);
        }
        if (!("").equals(name)) {
            client.setName(name);
        }
        if (!("").equals(dateOfBirth)) {
            Date date = Date.valueOf(dateOfBirth);
            LocalDate localDate
                    = new java.sql.Date(date.getTime()).toLocalDate();
            client.setDateOfBirth(localDate);
        }

        service.save(client);
        request.getSession().setAttribute("client",
                service.findById(client.getId()));
        String encoded
                = jspPage.encode(MessageManager.getProperty("changedParam"));
        request.getSession().setAttribute("changedParameters",
                MessageManager.getProperty("changedParam"));

        factory.close();
        jspPage.setPage("/profile?message=" + encoded);
        return jspPage;
    }
}
