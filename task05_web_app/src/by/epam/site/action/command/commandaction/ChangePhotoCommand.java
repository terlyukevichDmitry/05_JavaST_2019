package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.MessageManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.Image;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.exception.IncorrectDataException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import by.epam.site.validation.ImageValidator;
import by.epam.site.validation.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * This class we use for changing photo in person account.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ChangePhotoCommand implements ActionCommand {
    /**
     * Method in which we do action. In this class it is
     * changing photo in person account.
     * @param request object, that we use to take different parameters with
     * information that essential for accept the result.
     * @return jspPage object with page.
     * @throws ConstantException for checking exception situations.
     * @throws SQLException for checking exception situations.
     * @throws ClassNotFoundException for checking exception situations.
     */
    @Override
    public JspPage execute(final HttpServletRequest request)
            throws ConstantException, SQLException, ClassNotFoundException,
            IOException, ServletException, IncorrectDataException {
        JspPage jspPage = new JspPage();
        User user = (User) request.getSession().getAttribute("user");

        Validator<Image> imageValidator = new ImageValidator();
        Image image = imageValidator.validate(request);

        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        ClientService service = factory.getService(ClientService.class);
        Client client = service.findById(user.getId());
        client.setFilePath(image.getFilePath());
        service.save(client);
        factory.close();

        Calendar calendar = Calendar.getInstance();
        String encode = jspPage.encode(
                String.valueOf(calendar.get(Calendar.SECOND)));

        request.getSession().setAttribute("modelTextInfo",
                MessageManager.getProperty("changedAction"));

        jspPage.setPage("/profile?message=" + encode);
        return jspPage;
    }
}
