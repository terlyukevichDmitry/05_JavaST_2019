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
import java.sql.SQLException;
import java.util.Objects;

/**
 * This class we use for changing user password.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ChangePasswordAction implements ActionCommand {
    /**
     * Final value.
     */
    private final int four = 4;
    /**
     * Method in which we do action. In this class it is
     * changing user password.
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
        String password = request.getParameter("changePassword");
        String confirm = request.getParameter("changeConfirm");
        String oldPassword = request.getParameter("oldPassword");
        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        UserService service = factory.getService(UserService.class);
        User user = (User) request.getSession().getAttribute("user");
        String encoded = null;
        if (user.getPassword().equals(service.mdFiveMethod(oldPassword))) {
            if (Objects.equals(password, confirm)
                    && password.length() >= four) {
                user.setPassword(password);
                service.save(user);
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("positiveScript",
                        MessageManager.getProperty("completed"));
                encoded = jspPage.encode(
                        MessageManager.getProperty("completed"));
                factory.close();
            } else {
                encoded = jspPage.encode(MessageManager.getProperty(
                        "incorrectData"));
                request.getSession().setAttribute("errorPassword",
                        MessageManager.getProperty("incorrectData"));
            }
        } else {
            encoded = jspPage.encode(MessageManager.getProperty(
                    "incorrectOldPassword"));
            request.getSession().setAttribute("errorPassword",
                    MessageManager.getProperty("incorrectOldPassword"));
        }
        jspPage.setPage("/profile?message=" + encoded);
        return jspPage;
    }
}
