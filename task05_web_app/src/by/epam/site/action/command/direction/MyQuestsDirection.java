package by.epam.site.action.command.direction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.UsedQuest;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * This class we use to get direction on user ordered quests page.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class MyQuestsDirection implements ActionCommand {
    /**
     * Method in which we do action. In this class it is
     * getting direction on user ordered quests page.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        User user = (User) request.getSession().getAttribute("user");
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        UsedQuestService service = factory.getService(UsedQuestService.class);
        List<UsedQuest> usedQuests = service.findByClientId(user.getId());
        assert usedQuests != null;
        request.getSession().setAttribute(
                "userQuests", usedQuests);
        jspPage.setPage(ConfigurationManager.getProperty("myQuests"));
        return jspPage;
    }
}
