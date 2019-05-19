package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.User;
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

public class ShowUserOrderProfileCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException, SQLException, ClassNotFoundException, ParseException, IOException, ServletException, IncorrectDataException {
        JspPage jspPage = new JspPage();

        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        ClientService service = factory.getService(ClientService.class);
        String clientId = request.getParameter("clientId");
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
