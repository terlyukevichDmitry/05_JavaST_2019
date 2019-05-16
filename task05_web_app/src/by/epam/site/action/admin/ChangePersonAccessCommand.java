package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class ChangePersonAccessCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException,
            SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        int id = Integer.parseInt(request.getParameter("idToAddManager"));
        ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        UserService service = factory.getService(UserService.class);
        User user = service.findById(id);
        if (user.getRole().getIdentity() == 1) {
            user.setRole(Role.CLIENT);
        } else {
            user.setRole(Role.MANAGER);
        }
        service.save(user);
        String encode = jspPage.encode(MessageManager.getProperty("completed"));
        jspPage.setPage("/doManager?message=" + encode);
        return jspPage;
    }
}
