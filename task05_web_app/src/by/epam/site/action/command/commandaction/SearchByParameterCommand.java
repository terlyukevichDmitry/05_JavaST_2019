package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.QuestPlace;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchByParameterCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        QuestPlaceService service
                = factory.getService(QuestPlaceService.class);
        String title = request.getParameter("searchName");
        if (title != null) {
            List<QuestPlace> questPlaces = service.findAll();
            service.initData(questPlaces);
            questPlaces = findByParameter(questPlaces, title);
            request.getSession().setAttribute(
                    "questPlaces", questPlaces);
            String encoded = jspPage.encode(
                    MessageManager.getProperty("searchByParameter"));
            jspPage.setPage("/searchByParameter?message=" + encoded);
        } else {
            jspPage.setPage(
                    ConfigurationManager.getProperty("questPath"));
        }
        factory.close();
        return jspPage;
    }

    private List<QuestPlace> findByParameter(final List<QuestPlace> allQuests,
                                             final String title) {
        List<QuestPlace> questPlaces = new ArrayList<>();
        for (QuestPlace questPlace : allQuests) {
            char[] chars = title.toLowerCase().toCharArray();
            boolean checker = false;
            for (int i = 0;
                 i < questPlace.getQuest().getTitle().length(); i++) {
                for (char aChar : chars) {
                    if (questPlace.getQuest().getTitle().toLowerCase().charAt(i)
                            == aChar) {
                        checker = true;
                        break;
                    }
                }
            }
            if (checker) {
                questPlaces.add(questPlace);
            }
        }
        return questPlaces;
    }
}
