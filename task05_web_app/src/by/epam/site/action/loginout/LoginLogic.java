package by.epam.site.action.loginout;

import by.epam.site.dao.daoimpl.AbstractDAOImpl;
import by.epam.site.dao.daoimpl.UserDAOImpl;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;

import java.sql.SQLException;
import java.util.List;

class LoginLogic {
    private LoginLogic() {
    }

    static boolean checkLogin(String username, String password)
            throws ConstantException, SQLException, ClassNotFoundException {
        AbstractDAOImpl<User> abstractDAO = new UserDAOImpl();
        List<User> userList = abstractDAO.readAll();
        for (User user :userList) {
            if (!username.equals(user.getLogin())
                    || !password.equals(user.getPassword())) {
                continue;
            }
            return true;
        }
        return false;
    }
}
