package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.ReviewService;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.interfaces.ServiceFactory;

import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * This class we use for removing quest.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class RemoveQuestCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class it is removing quest.
     * This action has do only administrator.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     * @throws SQLException for checking exception situations.
     * @throws ClassNotFoundException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException, ClassNotFoundException, SQLException {
        JspPage jspPage = new JspPage();
        int id = Integer.parseInt(request.getParameter("idRemoveQuest"));
        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());

        ReviewService reviewService = factory.getService(ReviewService.class);
        List<Review> reviewList = reviewService.findAll();
        for (Review review :reviewList) {
            if (review.getQuestPlace().getId() == id) {
                reviewService.delete(review.getId());
            }
        }

        UsedQuestService usedQuestService
                = factory.getService(UsedQuestService.class);
        usedQuestService.deleteByQuestPlaceId(id);

        QuestPlaceService questPlaceService
                = factory.getService(QuestPlaceService.class);
        //QuestPlace questPlace = questPlaceService.findById(id);
        questPlaceService.delete(id);
//
//        QuestService questService = factory.getService(QuestService.class);
//        questService.delete(questPlace.getQuest().getId());
//
//        ImageService imageService = factory.getService(ImageService.class);
//        imageService.delete(questPlace.getImage().getId());

        Calendar calendar = Calendar.getInstance();
        String encoded = jspPage.encode(
                String.valueOf(calendar.get(Calendar.SECOND)));
        jspPage.setPage(
                ConfigurationManager.getProperty("questPath"));
        request.getSession().setAttribute("modelTextInfo",
                MessageManager.getProperty("removeAction"));
        jspPage.setPage("/quests?message=" + encoded);
        return jspPage;
    }
}
