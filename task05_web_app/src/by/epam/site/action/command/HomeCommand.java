package by.epam.site.action.command;


import javax.servlet.http.HttpServletRequest;

public class HomeCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty("home");
    }
}
