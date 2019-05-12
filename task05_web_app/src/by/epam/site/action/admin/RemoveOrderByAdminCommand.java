package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;

public class RemoveOrderByAdminCommand implements ActionCommand {
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException {
        JspPage jspPage = new JspPage();
        String idPerson = (String)request.getSession().getAttribute("alloo");
        System.out.println("idPerson = " + idPerson);
        String id = request.getParameter("idToRemove");
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        UsedQuestService usedQuestService
                = factory.getService(UsedQuestService.class);
        if (idPerson != null) {
            usedQuestService.delete(
                    Integer.parseInt(idPerson), Integer.parseInt(id));
        }
        jspPage.setPage("/showUsers");
        return jspPage;
    }
}
