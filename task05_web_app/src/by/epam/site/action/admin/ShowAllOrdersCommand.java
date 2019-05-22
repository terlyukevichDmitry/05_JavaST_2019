package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.UsedQuest;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class we use for showing all user orders.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ShowAllOrdersCommand implements ActionCommand {
    /**
     * Final value.
     */
    private final int three = 3;
    /**
     * Method in which we do action. In this class
     * it is showing all user orders.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     * @throws SQLException for checking exception situations.
     * @throws ClassNotFoundException for checking exception situations.
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

        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        UsedQuestService service = factory.getService(UsedQuestService.class);
        List<UsedQuest> usedQuests = service.findAll();
        service.initData(usedQuests);

        String encode = request.getParameter("message");
        jspPage.getModel(jspPage, encode, request);

        int numberOfElement = three;
        int nOfPages
                = (int) Math.ceil(usedQuests.size() * 1.0 / numberOfElement);
        List<UsedQuest> list = findByBorder(
                numberOfElement, currentPageInt, usedQuests);

        request.getSession().setAttribute("orders", list);
        request.getSession().setAttribute("num_of_pages", nOfPages);
        request.getSession().setAttribute("current_page", currentPageInt);

        jspPage.setPage(ConfigurationManager.getProperty("clientOrders"));

        return jspPage;
    }
    /**
     * Method in which we find persons in different borders for pagination on
     * web page.
     * @param numberOfElement max number of person on page.
     * @param currentPageInt number of page.
     * @param reviews all users what we have in database.
     * @return list with all users.
     */
    private List<UsedQuest> findByBorder(final int numberOfElement,
                                      final int currentPageInt,
                                      final List<UsedQuest> reviews) {
        int counter = currentPageInt * numberOfElement - numberOfElement;
        List<UsedQuest> list = new ArrayList<>();
        int mi = reviews.size() - counter;
        int z = 0;
        if (mi > numberOfElement) {
            z = numberOfElement;
        } else {
            z = mi;
        }

        for (int i = counter; i < z + counter; i++) {
            list.add(reviews.get(i));
        }
        return list;
    }
}
