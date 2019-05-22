package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.UsedQuest;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * This class we use for accepting orders different users.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class AcceptOrderCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class  it is accepting orders.
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
        String idPerson = (String) request.getSession().getAttribute("alloo");
        String id = request.getParameter("idToAcceptOrder");
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        UsedQuestService usedQuestService
                = factory.getService(UsedQuestService.class);
        UsedQuest usedQuest = usedQuestService.findById(Integer.parseInt(id));
        usedQuest.setControl(true);
        if (idPerson != null) {
            usedQuestService.save(usedQuest);
        }
        factory.close();
        jspPage.setPage("/showUsers");
        return jspPage;
    }
}
