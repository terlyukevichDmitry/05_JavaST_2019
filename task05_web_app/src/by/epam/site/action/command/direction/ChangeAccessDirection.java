package by.epam.site.action.command.direction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.exception.ConstantException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class ChangeAccessDirection implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException,
            SQLException, ClassNotFoundException, ParseException, IOException,
            ServletException {
        JspPage jspPage = new JspPage();
        jspPage.setPage(ConfigurationManager.getProperty("showUsers"));
        return jspPage;
    }
}
