package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;

public class RemovePersonCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        String removeId = request.getParameter("idToRemovePerson");
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        UserService service = factory.getService(UserService.class);
        User user = service.findById(Integer.parseInt(removeId));
        if (user != null) {
            ClientService clientService
                    = factory.getService(ClientService.class);
            clientService.delete(user.getId());
            service.delete(user.getId());
            jspPage.setPage("/showUsers");
        } else {
            jspPage.setPage("/showUsers?a=nopeMotherFacker");
        }
        factory.close();
        return jspPage;
    }
}
