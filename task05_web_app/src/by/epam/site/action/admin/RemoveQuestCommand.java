package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

public class RemoveQuestCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        int id = Integer.parseInt(request.getParameter("idRemoveQuest"));
        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        UsedQuestService usedQuestService
                = factory.getService(UsedQuestService.class);
        usedQuestService.deleteByQuestPlaceId(id);
        QuestPlaceService questPlaceService
                = factory.getService(QuestPlaceService.class);
        questPlaceService.delete(id);
        Calendar calendar = Calendar.getInstance();
        String encoded = jspPage.encode(
                String.valueOf(calendar.get(Calendar.SECOND)));
        jspPage.setPage("/quests?message=" + encoded);
        return jspPage;
    }
}
