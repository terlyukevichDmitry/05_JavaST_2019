package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
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

/**
 * This class we use for creating direction to page, where
 * administrator can create new quest.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class CreateQuestDirection implements ActionCommand {
    /**
     * Method in which we do action. In this class it is creating quest.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     * @throws SQLException for checking exception situations.
     * @throws ClassNotFoundException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
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

    /**
     * Method for getting not the same name of the place.
     * @param list with place objects.
     * @return list with place objects.
     */
    private List<QuestPlace> getPlaces(final List<QuestPlace> list) {
        List<QuestPlace> places = new ArrayList<>();
        for (QuestPlace questPlace : list) {
            boolean checker = false;
            if (!places.isEmpty()) {
                for (QuestPlace quest : places) {
                    if (quest.getAddress().equals(questPlace.getAddress())) {
                        checker = true;
                    }
                }
                if (!checker) {
                    places.add(questPlace);
                }
            } else {
                places.add(questPlace);
            }
        }
        return places;
    }
}
