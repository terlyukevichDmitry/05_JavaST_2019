package by.epam.site.action.command.commandaction;

import by.epam.site.action.command.ActionCommand;
import by.epam.site.action.factory.JspPage;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public JspPage execute(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        request.getSession().setMaxInactiveInterval(1);
        request.getSession().invalidate();
        JspPage jspPage = new JspPage();
        jspPage.setPage("/logout");
        return jspPage;
    }
}