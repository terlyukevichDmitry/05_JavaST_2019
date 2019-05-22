package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * This class we use to removing orders.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class RemoveOrderCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class it is
     * removing orders.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        String id = request.getParameter("idToRemove");
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        UsedQuestService usedQuestService
                = factory.getService(UsedQuestService.class);
        usedQuestService.delete(Integer.parseInt(id));
        factory.close();
        Calendar calendar = Calendar.getInstance();
        String encoded = jspPage.encode(
                String.valueOf(calendar.get(Calendar.SECOND)));
        request.getSession().setAttribute("modelTextInfo",
                MessageManager.getProperty("removeAction"));
        jspPage.setPage("/showOrders?message=" + encoded);
        return jspPage;
    }
}
