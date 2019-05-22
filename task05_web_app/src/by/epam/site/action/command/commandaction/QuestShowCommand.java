package by.epam.site.action.command.commandaction;

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
 * This class we use to showing all quests.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class QuestShowCommand implements ActionCommand {
    /**
     * Final value.
     */
    private final int three = 3;
    /**
     * Method in which we do action. In this class it is
     * showing all quests.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException,
            ClassNotFoundException, SQLException {
        JspPage jspPage = new JspPage();
        String encode = request.getParameter("message");
        jspPage.getModel(jspPage, encode, request);

        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        QuestPlaceService service
                = factory.getService(QuestPlaceService.class);
        List<QuestPlace> questPlaces = service.findAll();
        service.initData(questPlaces);

        String currentPage = request.getParameter("page");
        int currentPageInt;
        if (currentPage == null) {
            currentPage = "1";
            currentPageInt = Integer.parseInt(currentPage);
        } else {
            currentPageInt = Integer.parseInt(currentPage);
        }
        int numberOfElement = three;
        int nOfPages
                = (int) Math.ceil(questPlaces.size() * 1.0 / numberOfElement);

        List<QuestPlace> list = findByBorder(
                numberOfElement, currentPageInt, questPlaces);

        request.setAttribute("questPlaces", list);
        request.setAttribute("num_of_pages", nOfPages);
        request.setAttribute("current_page", currentPageInt);

        factory.close();
        jspPage.setPage(
                ConfigurationManager.getProperty("questPath"));
        return jspPage;
    }
    /**
     * Method in which we find persons in different borders for pagination on
     * web page.
     * @param numberOfElement max number of person on page.
     * @param currentPageInt number of page.
     * @param questPlaces all quest places which we have in database.
     * @return list with all users.
     */
    private List<QuestPlace> findByBorder(final int numberOfElement,
                                      final int currentPageInt,
                                      final List<QuestPlace> questPlaces) {
        int counter = currentPageInt * numberOfElement - numberOfElement;
        List<QuestPlace> list = new ArrayList<>();
        int mi = questPlaces.size() - counter;
        int z = 0;
        if (mi > numberOfElement) {
            z = numberOfElement;
        } else {
            z = mi;
        }

        for (int i = counter; i < z + counter; i++) {
            list.add(questPlaces.get(i));
        }
        return list;
    }
}
