package by.epam.site.service.interfaces;

import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;

import java.sql.SQLException;

public interface UserService extends Service {
    User findByLoginAndPassword(String login, String password) throws ConstantException, SQLException, ClassNotFoundException;
    void save(User user);
    void delete(Integer id);
}
