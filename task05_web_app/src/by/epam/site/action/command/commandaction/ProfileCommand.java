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

public class ProfileCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException {
        JspPage jspPage = new JspPage();

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
        factory.close();
        jspPage.setPage(
                ConfigurationManager.getProperty("profilePath"));
        return jspPage;
    }
}
