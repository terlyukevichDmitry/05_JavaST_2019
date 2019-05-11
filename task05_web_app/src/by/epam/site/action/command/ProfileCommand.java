package by.epam.site.action.command;

import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;

public class ProfileCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException {

        JspPage jspPage = new JspPage();
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        ClientService service = factory.getService(ClientService.class);
        User user = (User) request.getSession().getAttribute("user");
        Client client = service.findById(user.getId());
        if (client != null) {
            request.getSession().setAttribute(
                    "client", client);
        }
        jspPage.setPage(
                ConfigurationManager.getProperty("profilePath"));
        return jspPage;
    }
}
