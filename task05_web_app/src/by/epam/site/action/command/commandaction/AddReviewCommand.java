package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.QuestPlace;
import by.epam.site.entity.Review;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ReviewService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddReviewCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException, SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        String reviewMessage = request.getParameter("review");
        String idQuestPlace = request.getParameter("idQuestPlace");
        User user = (User) request.getSession().getAttribute("user");

        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        ReviewService service = factory.getService(ReviewService.class);
        Review review = new Review();
        review.setId(user.getId());
        Client client = new Client();
        client.setId(user.getId());
        review.setDate(LocalDate.now());
        review.setClient(client);
        review.setMessage(reviewMessage);
        QuestPlace questPlace = new QuestPlace();
        questPlace.setId(Integer.parseInt(idQuestPlace));
        review.setQuestPlace(questPlace);
        service.save(review);
        jspPage.setPage("/quests");
        return jspPage;
    }
}
