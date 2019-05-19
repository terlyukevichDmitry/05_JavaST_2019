package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.UsedQuest;
import by.epam.site.exception.ConstantException;
import by.epam.site.exception.IncorrectDataException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ShowAllOrdersCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException,
            SQLException, ClassNotFoundException, ParseException, IOException,
            ServletException, IncorrectDataException {
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

        int numberOfElement = 3;
        int nOfPages
                = (int)Math.ceil(usedQuests.size() * 1.0 / numberOfElement);
        List<UsedQuest> list = findByBorder(
                numberOfElement, currentPageInt, usedQuests);

        request.getSession().setAttribute("orders", list);
        request.getSession().setAttribute("num_of_pages", nOfPages);
        request.getSession().setAttribute("current_page", currentPageInt);

        jspPage.setPage(ConfigurationManager.getProperty("clientOrders"));

        return jspPage;
    }

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
