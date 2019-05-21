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
import java.util.ArrayList;
import java.util.List;

public class ShowQuestInformationCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        String id = request.getParameter("getQuestId");
        if (id == null) {
            id = String.valueOf(
                    request.getSession().getAttribute("getQuestId"));
        } else {
            request.getSession().setAttribute("getQuestId", id);
        }
        String encode = request.getParameter("message");
        jspPage.getModel(jspPage, encode, request);

        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        QuestPlaceService service = factory.getService(QuestPlaceService.class);
        QuestPlace questPlace = service.findById(Integer.parseInt(id));
        List<QuestPlace> questPlaceList = new ArrayList<>();
        questPlaceList.add(questPlace);
        service.initData(questPlaceList);
        request.setAttribute("questPlace", questPlace);

        jspPage.setPage(ConfigurationManager.getProperty("questInfo"));
        return jspPage;
    }
}
