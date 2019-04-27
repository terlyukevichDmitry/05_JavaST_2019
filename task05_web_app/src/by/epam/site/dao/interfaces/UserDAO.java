package by.epam.site.dao.interfaces;

import by.epam.site.entity.Role;
import by.epam.site.exception.ConstantException;

public interface UserDAO {
    void deleteByRole(final Integer id, final Role role)
            throws ConstantException, ClassNotFoundException;
}
