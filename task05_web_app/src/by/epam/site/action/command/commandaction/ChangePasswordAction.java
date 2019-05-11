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

public class ChangePasswordAction implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        String password = request.getParameter("changePassword");
        String confirm = request.getParameter("changeConfirm");
        if (Objects.equals(password, confirm)
                && password.length() >= 4) {
            ServiceFactory factory
                    = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
            UserService service = factory.getService(UserService.class);
            User user = (User) request.getSession().getAttribute("user");
            user.setPassword(password);
            service.save(user);
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("errorPassword",
                    MessageManager.getProperty("completed"));
            jspPage.setPage("/profile");
        } else {
            request.getSession().setAttribute("errorPassword",
                    MessageManager.getProperty("incorrectData"));
            jspPage.setPage("/profile?a=b");
        }
        return jspPage;
    }
}
