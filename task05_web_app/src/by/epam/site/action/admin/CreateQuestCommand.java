package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Image;
import by.epam.site.entity.Quest;
import by.epam.site.entity.QuestPlace;
import by.epam.site.exception.ConstantException;

import java.io.*;

import by.epam.site.exception.IncorrectDataException;
import by.epam.site.service.interfaces.ImageService;
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.QuestService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import by.epam.site.validation.ImageValidator;
import by.epam.site.validation.QuestValidator;
import by.epam.site.validation.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class CreateQuestCommand implements ActionCommand {

    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, SQLException,
            ClassNotFoundException, IOException,
            ServletException, IncorrectDataException {

        JspPage jspPage = new JspPage();
        String id = request.getParameter("options");
        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());

        QuestService service = factory.getService(QuestService.class);
        List<Quest> quests = service.findAll();

        Validator<Quest> questValidator = new QuestValidator();
        Quest quest = questValidator.validate(request);

        for (Quest element :quests) {
            if (element.getTitle().trim().equalsIgnoreCase(
                    quest.getTitle().trim())) {
                request.getSession().setAttribute("crashMessage",
                        MessageManager.getProperty("equalsTitle"));
                String encode= jspPage.encode(
                        MessageManager.getProperty("equalsTitle"));
                jspPage.setPage("/createQuest?message=" + encode);
                return jspPage;
            }
        }

        if (quest.getMaxPeople() > 9) {
            request.getSession().setAttribute(
                    "crashMessage",
                    MessageManager.getProperty("crashMessage"));
            String encode= jspPage.encode(
                    MessageManager.getProperty("crashMessage"));
            jspPage.setPage("/createQuest?message=" + encode);
            return jspPage;
        } else if (quest.getLevel() > 5) {
            request.getSession().setAttribute(
                    "crashMessage",
                    MessageManager.getProperty("bigLevel"));
            String encode= jspPage.encode(
                    MessageManager.getProperty("bigLevel"));
            jspPage.setPage("/createQuest?message=" + encode);
            return jspPage;
        } else if (id == null) {
            request.getSession().setAttribute(
                    "crashMessage",
                    MessageManager.getProperty("chooseRadioButton"));
            String encode= jspPage.encode(
                    MessageManager.getProperty("chooseRadioButton"));
            jspPage.setPage("/createQuest?message=" + encode);
            return jspPage;
        }

        service.save(quest);

        Quest questHelper = service.read(quest.getTitle());

        Validator<Image> imageValidator = new ImageValidator();
        Image image = imageValidator.validate(request);
        image.setId(questHelper.getId());

        ImageService imageService = factory.getService(ImageService.class);
        imageService.create(image);

        QuestPlaceService questPlaceService
                = factory.getService(QuestPlaceService.class);

        QuestPlace questPlace
                = questPlaceService.findById(Integer.parseInt(id));

        questPlace.setId(null);
        questPlace.setQuest(questHelper);
        questPlace.setImage(image);

        questPlaceService.save(questPlace);

        Calendar calendar = Calendar.getInstance();
        String encode = jspPage.encode(
                String.valueOf(calendar.get(Calendar.SECOND)));

        jspPage.setPage("/createQuest?message=" + encode);
        request.getSession().setAttribute("modelTextInfo",
                MessageManager.getProperty("addedAction"));
        factory.close();
        return jspPage;
    }
}
