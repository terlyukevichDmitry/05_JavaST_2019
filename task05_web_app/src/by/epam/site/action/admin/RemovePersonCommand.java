package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Review;
import by.epam.site.entity.UsedQuest;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.*;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class RemovePersonCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, ClassNotFoundException, SQLException {
        //10, 10, 33, 26
        JspPage jspPage = new JspPage();
        String removeId = request.getParameter("idToRemovePerson");
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        UserService service = factory.getService(UserService.class);
        User user = service.findById(Integer.parseInt(removeId));
        if (user != null) {
            service.delete(user.getId());
            ReviewService reviewService
                    = factory.getService(ReviewService.class);
            List<Review> reviewList = reviewService.findAll();
            for (Review review :reviewList) {
                if (review.getClient().getId() == Integer.parseInt(removeId)) {
                    reviewService.deleteByClientId(Integer.parseInt(removeId));
                }
            }

            UsedQuestService usedQuestService = factory.getService(UsedQuestService.class);
            List<UsedQuest> usedQuests = usedQuestService.findAll();
            for (UsedQuest usedQuest :usedQuests) {
                if (usedQuest.getClient().getId() == Integer.parseInt(removeId)) {
                    usedQuestService.delete(usedQuest.getId());
                }
            }
            ClientService clientService
                    = factory.getService(ClientService.class);
            clientService.delete(Integer.parseInt(removeId));
            jspPage.setPage("/showUsers");
        } else {
            jspPage.setPage("/showUsers?a=nopeMotherFacker");
        }
        factory.close();
        return jspPage;
    }
}
