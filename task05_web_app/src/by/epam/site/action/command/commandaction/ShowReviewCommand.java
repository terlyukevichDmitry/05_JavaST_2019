package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ReviewService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class ShowReviewCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
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
        String encode = request.getParameter("message");
        jspPage.getModel(jspPage, encode, request);

        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        ReviewService service = factory.getService(ReviewService.class);
        List<Review> reviews = service.findAll();
        int numberOfElement = 3;
        int nOfPages = (int)Math.ceil(reviews.size() * 1.0 / numberOfElement);
        service.initDate(reviews);
        Collections.reverse(reviews);
        List<Review> list = findByBorder(
                numberOfElement, currentPageInt, reviews);
        request.setAttribute("review", list);
        request.setAttribute("num_of_pages", nOfPages);
        request.setAttribute("current_page", currentPageInt);

        jspPage.setPage(ConfigurationManager.getProperty("review"));
        factory.close();
        return jspPage;
    }

    private List<Review> findByBorder(final int numberOfElement,
                                      final int currentPageInt,
                                      final List<Review> reviews) {
        int counter = currentPageInt * numberOfElement - numberOfElement;
        List<Review> list = new ArrayList<>();
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
