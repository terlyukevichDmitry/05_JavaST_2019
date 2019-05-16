package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.QuestPlace;
import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.*;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class RemoveQuestCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
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
