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

/**
 * This class we use to showing user profile.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class UserProfileDirection implements ActionCommand {
    /**
     * Method in which we do action. In this class
     * it is showing user profile.
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
