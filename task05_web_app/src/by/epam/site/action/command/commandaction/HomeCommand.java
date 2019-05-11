package by.epam.site.action.command.commandaction;


import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.command.ConfigurationManager;
import by.epam.site.action.factory.JspPage;

import javax.servlet.http.HttpServletRequest;

public class HomeCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) {
        JspPage jspPage = new JspPage();
        jspPage.setPage(
                ConfigurationManager.getProperty("home"));
        return jspPage;
    }
}
