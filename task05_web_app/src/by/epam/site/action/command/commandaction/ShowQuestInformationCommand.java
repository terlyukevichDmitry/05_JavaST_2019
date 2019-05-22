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

/**
 * This class we use to showing information about quest.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ShowQuestInformationCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class it is
     * showing information about quest.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
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
