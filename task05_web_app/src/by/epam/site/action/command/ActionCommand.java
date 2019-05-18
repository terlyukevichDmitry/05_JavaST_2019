package by.epam.site.action.command;

import by.epam.site.action.factory.JspPage;
import by.epam.site.exception.ConstantException;
import by.epam.site.exception.IncorrectDataException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public interface ActionCommand {
    JspPage execute(HttpServletRequest request) throws ConstantException, SQLException, ClassNotFoundException, ParseException, IOException, ServletException, IncorrectDataException;
}
