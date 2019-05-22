package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * This class we use for removing user orders. And this action has only
 * administrator.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class RemoveOrderByAdminCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class it is removing user orders.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException {
        JspPage jspPage = new JspPage();
        String idPerson
                = String.valueOf(request.getSession().getAttribute("alloo"));
        String id = request.getParameter("idToRemove");
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        UsedQuestService usedQuestService
                = factory.getService(UsedQuestService.class);
        if (idPerson != null) {
            usedQuestService.delete(
                    Integer.parseInt(idPerson), Integer.parseInt(id));
        }
        factory.close();
        jspPage.setPage("/showUsers");
        return jspPage;
    }
}
