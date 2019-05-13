package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class CreatePersonCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_CONFIRM_PASSWORD = "confirm";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_SURNAME = "surname";
    private static final String PARAM_PATRONYMIC = "patronymic";
    private static final String PARAM_EMAIL = "email";
    private static final String PARAM_PHONE = "phone";
    private static final String PARAM_DATE_OF_BIRTH = "dateOfBirth";

    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, ClassNotFoundException, SQLException {
        JspPage jspPage = new JspPage();
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String confirmPassword
                = request.getParameter(PARAM_NAME_CONFIRM_PASSWORD);
        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        UserService service = factory.getService(UserService.class);
        List<User> userList = service.findAll();
        if (!checkLogin(userList, login)) {
            if(Objects.equals(password, confirmPassword) && password.length() >= 4) {
                User user = new User();
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(Role.CLIENT);

                service.save(user);
                ClientService clientService
                        = factory.getService(ClientService.class);
                Client client = new Client();
                client.setName(request.getParameter(PARAM_NAME));
                client.setSurname(request.getParameter(PARAM_SURNAME));
                client.setPatronymic(request.getParameter(PARAM_PATRONYMIC));
                client.setEmail(request.getParameter(PARAM_EMAIL));
                client.setPhone(request.getParameter(PARAM_PHONE));
                String newYorkDateTimePattern = "yyyy-MM-dd";
                DateTimeFormatter newYorkDateFormatter
                        = DateTimeFormatter.ofPattern(newYorkDateTimePattern);
                LocalDate localDate = LocalDate.from(newYorkDateFormatter.parse(
                        request.getParameter(PARAM_DATE_OF_BIRTH)));
                client.setDateOfBirth(localDate);

                clientService.save(client);

                jspPage.setPage("/signup");
                request.getSession().setAttribute("createInfo",
                        MessageManager.getProperty("correctMessage"));
            } else {
                jspPage.setPage("/signup?a=b");
                request.getSession().setAttribute("createInfo",
                        MessageManager.getProperty("incorrectData"));
            }
        } else {
            jspPage.setPage("/signup?a=incorrectLogin");
            request.getSession().setAttribute("createInfo",
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
