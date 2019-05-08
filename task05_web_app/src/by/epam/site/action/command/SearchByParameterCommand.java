package by.epam.site.action.command;

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
    public String execute(HttpServletRequest request) throws ConstantException, SQLException, ClassNotFoundException {
        ServiceFactory factory = new ServiceFactoryImpl(
                new SqlTransactionFactoryImpl());
        QuestPlaceService service
                = factory.getService(QuestPlaceService.class);
        String title = request.getParameter("searchName");
        List<QuestPlace> questPlaces = service.findByName(title);
        service.initData(questPlaces);
        if (questPlaces != null) {
            request.getSession().setAttribute(
                    "questPlaces", questPlaces);
        }
        return ConfigurationManager.getProperty("questPath");
    }
}
