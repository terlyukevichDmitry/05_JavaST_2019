package by.epam.site.action.command;

import by.epam.site.action.factory.JspPage;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        request.getSession().setMaxInactiveInterval(1);
        request.getSession().invalidate();
        JspPage jspPage = new JspPage();
        jspPage.setPage(
                ConfigurationManager.getProperty("home"));
        return jspPage;
    }
}