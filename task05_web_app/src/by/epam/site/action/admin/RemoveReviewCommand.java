package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ReviewService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

public class RemoveReviewCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, ClassNotFoundException {
        JspPage jspPage = new JspPage();
        String idReview = request.getParameter("getReviewId");

        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        ReviewService service = factory.getService(ReviewService.class);
        service.delete(Integer.parseInt(idReview));
        factory.close();
        Calendar calendar = Calendar.getInstance();
        String encode
                = jspPage.encode(String.valueOf(calendar.get(Calendar.SECOND)));
        jspPage.setPage("/review?message=" + encode);
        request.getSession().setAttribute("modelTextInfo",
                MessageManager.getProperty("removeAction"));
        return jspPage;
    }
}
