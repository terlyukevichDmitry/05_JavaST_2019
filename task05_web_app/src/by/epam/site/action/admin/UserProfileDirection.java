package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.UsedQuest;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class UserProfileDirection implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        String personId = request.getParameter("personId");
        if (personId == null) {
            personId = String.valueOf(request.getSession().getAttribute(
                    "personIdInformation"));
        } else {
            request.getSession().setAttribute("personIdInformation",
                    personId);
        }
        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        UsedQuestService service = factory.getService(UsedQuestService.class);
        List<UsedQuest> usedQuests
                = service.findByClientId(Integer.parseInt(personId));
        if (usedQuests != null) {
            request.getSession().setAttribute("alloo", personId);
            request.getSession().setAttribute("userQuests", usedQuests);
        }
        factory.close();
        jspPage.setPage(
                ConfigurationManager.getProperty("goToUserProfile"));
        return jspPage;
    }
}
