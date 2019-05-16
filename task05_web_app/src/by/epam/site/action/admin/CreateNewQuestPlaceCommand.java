package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.Image;
import by.epam.site.entity.Quest;
import by.epam.site.entity.QuestPlace;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;

public class CreateNewQuestPlaceCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();

        String placeName = request.getParameter("placeName");
        String address = request.getParameter("addressName");
        String phoneNumber = request.getParameter("phoneNumber");

        if (("").trim().equals(placeName) || ("").trim().equals(address)
                || ("").trim().equals(phoneNumber)) {
            request.getSession().setAttribute("incorrectDataForQuestPlace",
                    MessageManager.getProperty("incorrectDataForQuestPlace"));
            String encode = jspPage.encode(
                    MessageManager.getProperty("incorrectDataForQuestPlace"));
            jspPage.setPage("/createQuest?message=" + encode);
            return jspPage;
        } else {
            ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
            QuestPlaceService service = factory.getService(QuestPlaceService.class);

            QuestPlace questPlace = new QuestPlace();
            questPlace.setAddress(address);
            questPlace.setName(placeName);
            questPlace.setPhone(phoneNumber);

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
