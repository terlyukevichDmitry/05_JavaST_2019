package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Image;
import by.epam.site.entity.Quest;
import by.epam.site.entity.QuestPlace;
import by.epam.site.exception.ConstantException;
import by.epam.site.exception.IncorrectDataException;
import by.epam.site.service.interfaces.ImageService;
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.QuestService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import by.epam.site.validation.ImageValidator;
import by.epam.site.validation.QuestPlaceValidator;
import by.epam.site.validation.QuestValidator;
import by.epam.site.validation.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * This class we use for updating information about quest.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class UpdateQuestCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class
     * it is updating information about quest.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     * @throws SQLException for checking exception situations.
     * @throws ClassNotFoundException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException,
            SQLException, ClassNotFoundException, IOException,
            ServletException, IncorrectDataException {
        JspPage jspPage = new JspPage();

        String id = request.getParameter("oldInfoId");

        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        QuestPlaceService service = factory.getService(QuestPlaceService.class);
        QuestPlace questPlace = service.findById(Integer.parseInt(id));

        Validator<Quest> validator = new QuestValidator();
        Quest quest = validator.validate(request);

        Validator<QuestPlace> questPlaceValidator = new QuestPlaceValidator();
        QuestPlace newQuestPlace = questPlaceValidator.validate(request);

        Validator<Image> imageValidator = new ImageValidator();
        Image image = imageValidator.validate(request);
        image.setId(questPlace.getImage().getId());

        ImageService imageService = factory.getService(ImageService.class);
        imageService.save(image);

        quest.setId(questPlace.getQuest().getId());
        QuestService questService = factory.getService(QuestService.class);
        questService.save(quest);

        newQuestPlace.setId(questPlace.getId());
        newQuestPlace.setQuest(quest);
        newQuestPlace.setImage(image);

        service.save(newQuestPlace);
        factory.close();
        Calendar calendar = Calendar.getInstance();
        String encode = jspPage.encode(
                String.valueOf(calendar.get(Calendar.SECOND)));

        jspPage.setPage("/updateQuest?message=" + encode);
        request.getSession().setAttribute("modelTextInfo",
                MessageManager.getProperty("changedAction"));
        request.getSession().setAttribute("idUpdateQuest", id);

        return jspPage;
    }
}
