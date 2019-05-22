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

/**
 * This class we use to searching user by username.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class SearchByNameCommand implements ActionCommand {
    /**
     * Final value.
     */
    private final int three = 3;
    /**
     * Method in which we do action. In this class it is
     * searching user by username.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        String currentPage = request.getParameter("page");
        int currentPageInt;
        if (currentPage == null) {
            currentPage = "1";
            currentPageInt = Integer.parseInt(currentPage);
        } else {
            currentPageInt = Integer.parseInt(currentPage);
        }
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        QuestPlaceService service
                = factory.getService(QuestPlaceService.class);
        String title = request.getParameter("searchName");
        if (title != null) {
            List<QuestPlace> questPlaces = service.findAll();
            service.initData(questPlaces);
            questPlaces = findByParameter(questPlaces, title);
            int numberOfElement = three;
            int nOfPages
                    = (int) Math.ceil(questPlaces.size() * 1.0
                    / numberOfElement);
            List<QuestPlace> list = findByBorder(
                    numberOfElement, currentPageInt, questPlaces);

            request.getSession().setAttribute("questPlaces", list);
            request.getSession().setAttribute("num_of_pages", nOfPages);
            request.getSession().setAttribute("current_page", currentPageInt);
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

    /**
     * Method in which we can find quest place by title.
     * @param allQuests in our database.
     * @param title quest name.
     * @return list with quest places with this name.
     */
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
