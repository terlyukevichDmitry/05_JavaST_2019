package by.epam.site.action.command.direction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.exception.ConstantException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class SearchByParameterDirection implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) throws ConstantException, SQLException, ClassNotFoundException, ParseException {
        JspPage jspPage = new JspPage();
        jspPage.setPage(ConfigurationManager.getProperty("questPath"));
        return jspPage;
    }
}
