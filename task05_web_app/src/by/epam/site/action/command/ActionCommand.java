package by.epam.site.action.command;

import by.epam.site.exception.ConstantException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface ActionCommand {
    String execute(HttpServletRequest request) throws ConstantException, SQLException, ClassNotFoundException;
}
