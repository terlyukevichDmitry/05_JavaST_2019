package by.epam.site.action.command.direction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;
import by.epam.site.exception.ConstantException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class SignUpDirection implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request)
            throws ConstantException, SQLException,
            ClassNotFoundException, ParseException {
        JspPage jspPage = new JspPage();
        String encoded = request.getParameter("message");
        if (encoded == null) {
            request.getSession().setAttribute("errorInfo", "");
        }
        jspPage.setPage(ConfigurationManager.getProperty("signUp"));
        return jspPage;
    }
}
