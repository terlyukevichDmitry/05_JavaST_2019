package by.epam.site.action.logic;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        if (LoginLogic.checkLogin(login, pass)) {
            request.setAttribute("user", login);
            page = ConfigurationManager.getProperty("home");
            //page = ConfigurationManager.getProperty("jsp/home.jsp");
        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("loginerror"));
            page = ConfigurationManager.getProperty("error");
        }
        return page;
    }
}
