package by.epam.site.service.interfaces;

import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;

import java.sql.SQLException;
import java.util.List;

public interface UserService extends Service {
    List<User> findAll() throws ConstantException,
            SQLException, ClassNotFoundException;
    User findByLoginAndPassword(String login, String password)
            throws ConstantException, SQLException, ClassNotFoundException;
    User findById(Integer id) throws ConstantException;
    void save(User user) throws ConstantException, ClassNotFoundException;
    void delete(Integer id) throws ClassNotFoundException, ConstantException;
}
