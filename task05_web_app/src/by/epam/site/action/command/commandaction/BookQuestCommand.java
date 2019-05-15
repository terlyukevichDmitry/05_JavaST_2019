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

        UsedQuest usedQuest = new UsedQuest();
        usedQuest.setQuestPlace(questPlace);

        Client client = new Client();
        client.setId(user.getId());
        usedQuest.setClient(client);
        usedQuest.setDate(LocalDate.now());
        usedQuest.setControl(true);
        usedQuestService.save(usedQuest);
        factory.close();
        Calendar calendar = Calendar.getInstance();
        String encoded = jspPage.encode(
                String.valueOf(calendar.get(Calendar.SECOND)));

        jspPage.setPage("/quests?message=" + encoded);
        return jspPage;
    }
}
