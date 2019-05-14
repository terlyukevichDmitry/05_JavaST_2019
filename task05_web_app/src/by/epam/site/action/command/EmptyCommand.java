package by.epam.site.action.command;

import by.epam.site.action.factory.GetCommand;
import by.epam.site.action.factory.JspPage;
import by.epam.site.exception.ConstantException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class EmptyCommand implements ActionCommand {

    @Override
    public JspPage execute(HttpServletRequest request) {
        JspPage jspPage = new JspPage();
        String actionValue = String.valueOf(request.getAttribute("action"));
        try {
            GetCommand currentEnum = GetCommand.getEnum(actionValue);
            assert currentEnum != null;
            ActionCommand current = currentEnum.getCurrentCommand();
            jspPage = current.execute(request);
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", actionValue
                    + MessageManager.getProperty("wrongaction"));
        } catch (ConstantException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jspPage;
    }
}