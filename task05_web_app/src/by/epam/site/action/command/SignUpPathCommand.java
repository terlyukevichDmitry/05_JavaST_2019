package by.epam.site.action.command;


import javax.servlet.http.HttpServletRequest;

public class SignUpPathCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty("signUp");
    }
}
