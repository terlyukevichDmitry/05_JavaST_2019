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
import java.text.ParseException;
import java.util.Calendar;

public class UpDateQuestCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException,
            SQLException, ClassNotFoundException, ParseException, IOException,
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
