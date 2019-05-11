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
import java.util.List;

public class SearchByParameterCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        QuestPlaceService service
                = factory.getService(QuestPlaceService.class);
        String title = request.getParameter("searchName");
        if (title != null) {
            List<QuestPlace> questPlaces = service.findByName(title);
            service.initData(questPlaces);
            if (questPlaces != null) {
                request.getSession().setAttribute(
                        "questPlaces", questPlaces);
            }
            jspPage.setPage("/searchByParameter");
        } else {
            jspPage.setPage(
                    ConfigurationManager.getProperty("questPath"));
        }
        return jspPage;
    }
}
