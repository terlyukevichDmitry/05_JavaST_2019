package by.epam.site.dao.daointerfaces;

import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;

public interface UserDAO extends DaoPattern<User> {
    void deleteByRole(final Integer id, final Role role)
            throws ConstantException, ClassNotFoundException;

    User read(String login, String password) throws ConstantException;
    User read(Integer id) throws ConstantException;
    User read(String login, SqlTransaction transaction)
            throws ConstantException;
}
