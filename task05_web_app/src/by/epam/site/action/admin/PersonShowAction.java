package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonShowAction implements ActionCommand {

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

        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        UserService service = factory.getService(UserService.class);
        List<User> users = service.findAll();
        int numberOfElement = 4;
        int nOfPages = (int)Math.ceil(users.size() * 1.0 / numberOfElement);
        List<User> list = findByBorder(
                numberOfElement, currentPageInt, users);
        request.getSession().setAttribute("userList", list);
        request.setAttribute("review", list);
        request.setAttribute("num_of_pages", nOfPages);
        request.setAttribute("current_page", currentPageInt);
        factory.close();
        jspPage.setPage(ConfigurationManager.getProperty("showUsers"));
        return jspPage;
    }

    private List<User> findByBorder(final int numberOfElement,
                                      final int currentPageInt,
                                      final List<User> reviews) {
        int counter = currentPageInt * numberOfElement - numberOfElement;
        List<User> list = new ArrayList<>();
        int mi = reviews.size() - counter;
        int checkNumber;
        if (mi > numberOfElement) {
            checkNumber = numberOfElement;
        } else {
            checkNumber = mi;
        }

        for (int i = counter; i < checkNumber + counter; i++) {
            list.add(reviews.get(i));
        }
        return list;
    }
}
