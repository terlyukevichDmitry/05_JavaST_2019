package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.exception.IncorrectDataException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import by.epam.site.validation.ClientValidator;
import by.epam.site.validation.UserValidator;
import by.epam.site.validation.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class CreatePersonCommand implements ActionCommand {

    private static final String PARAM_NAME_CONFIRM_PASSWORD = "confirm";

    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, ClassNotFoundException,
            SQLException, IncorrectDataException,
            IOException, ServletException {

        JspPage jspPage = new JspPage();
        Validator<Client> clientValidator = new ClientValidator();
        Client client = clientValidator.validate(request);
        Validator<User> userValidator = new UserValidator();
        User user = userValidator.validate(request);

        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        UserService service = factory.getService(UserService.class);
        List<User> userList = service.findAll();
        if (!checkLogin(userList, user.getLogin())) {
            if(Objects.equals(user.getPassword(),
                    request.getParameter(PARAM_NAME_CONFIRM_PASSWORD))
                    && user.getPassword().length()
                    >= 4) {
                service.save(user);
                ClientService clientService
                        = factory.getService(ClientService.class);
                clientService.save(client);
                jspPage.setPage("/login");
                request.getSession().setAttribute("signUpMessage",
                        MessageManager.getProperty("correctMessage"));
            } else {
                String encoded = jspPage.encode(
                        MessageManager.getProperty("incorrectData"));
                jspPage.setPage("/signup?message=" + encoded);
                request.getSession().setAttribute("errorInfo",
                        MessageManager.getProperty("incorrectData"));
            }
        } else {
            String encoded = jspPage.encode(
                    MessageManager.getProperty("equalsLogin"));
            jspPage.setPage("/signup?message=" + encoded);
            request.getSession().setAttribute("errorInfo",
                    MessageManager.getProperty("equalsLogin"));
        }
        return jspPage;
    }

    private boolean checkLogin(final List<User> users, final String login) {
        for (User user :users) {
            if (login.equals(user.getLogin())) {
                return true;
            }
        }
        return false;
    }
}
