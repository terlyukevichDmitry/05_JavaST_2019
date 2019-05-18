package by.epam.site.validation;

import by.epam.site.entity.Client;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.IncorrectDataException;

import javax.servlet.http.HttpServletRequest;

public class UserValidator implements Validator<User> {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_CONFIRM_PASSWORD = "confirm";

    @Override
    public User validate(HttpServletRequest request)
            throws IncorrectDataException {
        User user = new User();

        String login = request.getParameter(PARAM_NAME_LOGIN);
        if(login != null && !login.isEmpty()) {
            user.setLogin(login);
        } else {
            throw new IncorrectDataException(PARAM_NAME_LOGIN, login);
        }

        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String confirm = request.getParameter(PARAM_NAME_CONFIRM_PASSWORD);
        if(password != null && !password.isEmpty()
        && confirm != null && !confirm.isEmpty()) {
            user.setPassword(password);
        } else {
            throw new IncorrectDataException(PARAM_NAME_PASSWORD, password);
        }

        user.setRole(Role.CLIENT);
        return user;
    }
}
