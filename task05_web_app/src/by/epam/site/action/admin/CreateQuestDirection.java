package by.epam.site.action.admin;

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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CreateQuestDirection implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, SQLException,
            ClassNotFoundException {
        JspPage jspPage = new JspPage();
        String encode = request.getParameter("message");
        if (encode == null) {
            request.getSession().setAttribute("crashMessage", "");
            request.getSession().setAttribute(
                    "incorrectDataForQuestPlace", "");
        }
        jspPage.getModel(jspPage, encode, request);
        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        QuestPlaceService service = factory.getService(QuestPlaceService.class);
        List<QuestPlace> list = service.findAll();
        request.getSession().setAttribute("questPlace", getPlaces(list));
        factory.close();
        jspPage.setPage(ConfigurationManager.getProperty("createQuest"));
        return jspPage;
    }

    private List<QuestPlace> getPlaces(final List<QuestPlace> list) {
        List<QuestPlace> places = new ArrayList<>();
        for (QuestPlace questPlace: list) {
            boolean checker = false;
            if (!places.isEmpty()) {
                for (QuestPlace quest :places) {
                    if (quest.getAddress().equals(questPlace.getAddress())) {
                        checker = true;
                    }
                }
                if(!checker) {
                    places.add(questPlace);
                }
            } else {
                places.add(questPlace);
            }
        }
        return places;
    }
}
