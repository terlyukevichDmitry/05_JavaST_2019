package by.epam.site.action.command;


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
