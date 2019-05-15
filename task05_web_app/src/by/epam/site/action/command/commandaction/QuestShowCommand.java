package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.QuestPlace;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class QuestShowCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException,
            ClassNotFoundException, SQLException {
        JspPage jspPage = new JspPage();
        String encode = request.getParameter("message");
        if (encode == null) {
            request.getSession().setAttribute("model", false);
        } else {
            int encodedSeconds = Integer.parseInt(jspPage.decode(encode));
            Calendar calendar = Calendar.getInstance();
            int secondsNow = calendar.get(Calendar.SECOND);
            if (encodedSeconds + 10 > secondsNow) {
                request.getSession().setAttribute("model", true);
            } else {
                request.getSession().setAttribute("model", false);
            }
        }
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        QuestPlaceService service
                = factory.getService(QuestPlaceService.class);
        List<QuestPlace> questPlaces = service.findAll();
        service.initData(questPlaces);
        if (questPlaces != null) {
            request.getSession().setAttribute(
                    "questPlaces", questPlaces);
        }
        factory.close();
        jspPage.setPage(
                ConfigurationManager.getProperty("questPath"));
        return jspPage;
    }
}
