package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
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
import java.util.Calendar;

/**
 * This class we use for adding new review.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class AddReviewCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class it is adding new review.
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
        String reviewMessage = request.getParameter("review");
        String idQuestPlace = request.getParameter("idQuestPlace");
        request.getSession().setAttribute(
                "getQuestId", Integer.parseInt(idQuestPlace));
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

        Calendar calendar = Calendar.getInstance();
        String encoded = jspPage.encode(
                String.valueOf(calendar.get(Calendar.SECOND)));
        factory.close();
        jspPage.setPage("/questInformation?message=" + encoded);
        request.getSession().setAttribute("modelTextInfo",
                MessageManager.getProperty("addedAction"));
        return jspPage;
    }
}
