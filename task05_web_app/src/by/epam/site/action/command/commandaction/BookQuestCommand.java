package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.QuestPlace;
import by.epam.site.entity.UsedQuest;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class BookQuestCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException, SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        String id = request.getParameter("getId");
        User user = (User) request.getSession().getAttribute("user");

        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        QuestPlaceService service
                = factory.getService(QuestPlaceService.class);
        QuestPlace questPlace = service.findById(Integer.parseInt(id));
        UsedQuestService usedQuestService
                = factory.getService(UsedQuestService.class);

        if (checkOrders(usedQuestService, questPlace, user)) {
            Calendar calendar = Calendar.getInstance();
            String encoded = jspPage.encode(
                    String.valueOf(calendar.get(Calendar.SECOND)));

            request.getSession().setAttribute("modelTextInfo",
                    MessageManager.getProperty("ordered"));

            jspPage.setPage("/quests?message=" + encoded);
        }


        UsedQuest usedQuest = new UsedQuest();

        usedQuest.setQuestPlace(questPlace);

        Client client = new Client();
        client.setId(user.getId());

        ServiceFactory serviceFactory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        UsedQuestService service1
                = serviceFactory.getService(UsedQuestService.class);
        usedQuest.setClient(client);
        usedQuest.setDate(LocalDate.now());
        usedQuest.setControl(true);
        service1.save(usedQuest);

        serviceFactory.close();

        Calendar calendar = Calendar.getInstance();
        String encoded = jspPage.encode(
                String.valueOf(calendar.get(Calendar.SECOND)));

        request.getSession().setAttribute("modelTextInfo",
                MessageManager.getProperty("addedAction"));

        jspPage.setPage("/quests?message=" + encoded);
        return jspPage;
    }

    private Boolean checkOrders(final UsedQuestService usedQuestService,
                                final QuestPlace questPlace,
                                final User user)
            throws ConstantException, SQLException,ClassNotFoundException {
        List<UsedQuest> usedQuests = usedQuestService.findAll();
        usedQuestService.initData(usedQuests);
        for (UsedQuest usedQuest :usedQuests) {
            if (usedQuest.getQuestPlace().getQuest().getId().equals(
                    questPlace.getQuest().getId())
                    && usedQuest.getClient().getId().equals(user.getId())) {
                return true;
            }
        }
        return false;
    }
}
