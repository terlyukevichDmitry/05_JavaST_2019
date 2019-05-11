package by.epam.site.action.command;

import by.epam.site.action.admin.RemovePersonAction;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.QuestPlace;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class QuestsCommand implements ActionCommand {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(RemovePersonAction.class);

    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException,
            ClassNotFoundException, SQLException {
        JspPage jspPage = new JspPage();
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
        jspPage.setPage(
                ConfigurationManager.getProperty("questPath"));
        return jspPage;
    }
}
