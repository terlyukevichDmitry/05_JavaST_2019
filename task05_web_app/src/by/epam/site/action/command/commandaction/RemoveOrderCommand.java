package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;

public class RemoveOrderCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException {
        JspPage jspPage = new JspPage();
        User user = (User) request.getSession().getAttribute("user");
        String id = request.getParameter("idToRemove");
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        UsedQuestService usedQuestService
                = factory.getService(UsedQuestService.class);
        usedQuestService.delete(user.getId(), Integer.parseInt(id));
        jspPage.setPage("/myQuests");
        return jspPage;
    }
}
