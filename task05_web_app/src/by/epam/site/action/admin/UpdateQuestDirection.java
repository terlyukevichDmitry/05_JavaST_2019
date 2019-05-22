package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.QuestPlace;
import by.epam.site.exception.ConstantException;
import by.epam.site.exception.IncorrectDataException;
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateQuestDirection implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException,
            SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        String id = request.getParameter("idUpdateQuest");
        if (id == null) {
            id = String.valueOf(
                    request.getSession().getAttribute("idUpdateQuest"));
        } else {
            request.getSession().setAttribute("idUpdateQuest", id);
        }
        String encode = request.getParameter("message");
        jspPage.getModel(jspPage, encode, request);

        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        QuestPlaceService service = factory.getService(QuestPlaceService.class);
        List<QuestPlace> list = service.findAll();

        QuestPlace questPlace = service.findById(Integer.parseInt(id));
        List<QuestPlace> questPlaceList = new ArrayList<>();
        questPlaceList.add(questPlace);
        service.initData(questPlaceList);

        request.getSession().setAttribute("qP", getPlaces(list));
        request.getSession().setAttribute("oldPlace", questPlace);

        jspPage.setPage(ConfigurationManager.getProperty("changeQuestInfo"));
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
