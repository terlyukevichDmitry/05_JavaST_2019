package by.epam.site.action.admin;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.factory.JspPage;
import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Image;
import by.epam.site.entity.Quest;
import by.epam.site.exception.ConstantException;

import java.io.*;

import by.epam.site.service.interfaces.ImageService;
import by.epam.site.service.interfaces.QuestService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Objects;

public class CreateQuestCommand implements ActionCommand {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(CreateQuestCommand.class);
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, SQLException,
            ClassNotFoundException, IOException, ServletException {

        JspPage jspPage = new JspPage();
        String title = request.getParameter("title");
        int level = Integer.parseInt(request.getParameter("level"));
        int maxOfPeople
                = Integer.parseInt(request.getParameter("maxOfPeople"));
        Part part = request.getPart("fileLoader");
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String newFilePath = "C:\\05_JavaST_2019\\task05_web_app\\web\\images\\" + fileName;
        InputStream inputStream = part.getInputStream();
        OutputStream outputStream = new FileOutputStream(newFilePath);
        Objects.requireNonNull(outputStream, "out");
        byte[] buffer = new byte[8192];
        int read;
        while ((read = inputStream.read(buffer, 0, 8192)) >= 0) {
            outputStream.write(buffer, 0, read);
        }
        inputStream.close();
        outputStream.close();
        ServiceFactory factory
                = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        QuestService service = factory.getService(QuestService.class);
        Quest quest = new Quest();
        quest.setTitle(title);
        quest.setLevel(level);
        quest.setMaxPeople(maxOfPeople);
        service.save(quest);
        Quest quest1 = service.read(title);

        ImageService imageService = factory.getService(ImageService.class);
        Image image = new Image();
        image.setId(quest1.getId());
        image.setFilePath("images/" + fileName);
        imageService.create(image);
        jspPage.setPage("/createQuest");
        factory.close();
        return jspPage;
    }


}
