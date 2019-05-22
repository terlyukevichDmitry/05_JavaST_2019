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
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import by.epam.site.validation.QuestPlaceValidator;
import by.epam.site.validation.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * This class we use for creating quest place.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class CreateQuestPlaceCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class it is creating quest place.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     * @throws SQLException for checking exception situations.
     * @throws ClassNotFoundException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException,
            ServletException, IncorrectDataException, IOException {
        JspPage jspPage = new JspPage();

        Validator<QuestPlace> validator = new QuestPlaceValidator();
        QuestPlace questPlace = validator.validate(request);

        if (("").trim().equals(questPlace.getName())
                || ("").trim().equals(questPlace.getAddress())
                || ("").trim().equals(questPlace.getPhone())) {
            request.getSession().setAttribute("incorrectDataForQuestPlace",
                    MessageManager.getProperty("incorrectDataForQuestPlace"));
            String encode = jspPage.encode(
                    MessageManager.getProperty("incorrectDataForQuestPlace"));
            jspPage.setPage("/createQuest?message=" + encode);
            return jspPage;
        } else {
            ServiceFactory factory
                    = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
            QuestPlaceService service
                    = factory.getService(QuestPlaceService.class);

            Image image = new Image();
            image.setId(1);
            questPlace.setImage(image);

            Quest quest = new Quest();
            quest.setId(1);

            questPlace.setQuest(quest);
            service.save(questPlace);

            Calendar calendar = Calendar.getInstance();
            String encode = jspPage.encode(
                    String.valueOf(calendar.get(Calendar.SECOND)));
            factory.close();
            jspPage.setPage("/createQuest?message=" + encode);
            request.getSession().setAttribute("modelTextInfo",
                    MessageManager.getProperty("createdQuestPlace"));

            return jspPage;
        }
    }
}
