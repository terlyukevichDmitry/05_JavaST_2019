package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

public class RemoveOrderCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
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
