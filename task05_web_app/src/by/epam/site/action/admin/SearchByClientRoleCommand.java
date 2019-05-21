package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SearchByClientRoleCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException,
            SQLException, ClassNotFoundException, ParseException,
            IOException, ServletException {
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
        UserService service = factory.getService(UserService.class);
        List<User> users = service.findByRole(Role.CLIENT);

        int numberOfElement = 4;
        int nOfPages = (int)Math.ceil(users.size() * 1.0 / numberOfElement);
        List<User> list = findByBorder(
                numberOfElement, currentPageInt, users);
        request.getSession().setAttribute("userList", list);
        request.getSession().setAttribute("num_of_pages", nOfPages);
        request.getSession().setAttribute("current_page", currentPageInt);

        String encode = jspPage.encode(MessageManager.getProperty("completed"));
        jspPage.setPage("/searchByClientRole?message=" + encode);
        return jspPage;
    }

    private List<User> findByBorder(final int numberOfElement,
                                    final int currentPageInt,
                                    final List<User> users) {
        int counter = currentPageInt * numberOfElement - numberOfElement;
        List<User> list = new ArrayList<>();
        int mi = users.size() - counter;
        int checkNumber;
        if (mi > numberOfElement) {
            checkNumber = numberOfElement;
        } else {
            checkNumber = mi;
        }

        for (int i = counter; i < checkNumber + counter; i++) {
            list.add(users.get(i));
        }
        return list;
    }
}
