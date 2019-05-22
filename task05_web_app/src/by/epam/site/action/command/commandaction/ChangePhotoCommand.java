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
import by.epam.site.service.interfaces.ImageService;
import by.epam.site.service.interfaces.QuestService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import by.epam.site.validation.ImageValidator;
import by.epam.site.validation.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Objects;

public class ChangePhotoCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
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
