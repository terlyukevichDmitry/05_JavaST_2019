package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daointerfaces.UserDAO;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl extends ServiceImpl implements UserService {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public List<User> findAll() throws ConstantException,
            SQLException, ClassNotFoundException {
        UserDAO dao = transaction.createDaoImpl(UserDAO.class);
        return dao.readAll();
    }

    @Override
    public User findByLoginAndPassword(final String login,
                                       final String password)
            throws ConstantException {
        UserDAO dao = transaction.createDaoImpl(UserDAO.class);
        return dao.read(login, mdFiveMethod(password));
    }

    @Override
    public User findById(Integer identity) throws ConstantException {
        UserDAO dao = transaction.createDaoImpl(UserDAO.class);
        return dao.read(identity);
    }
    @Override
    public void save(User user) throws ConstantException {
        UserDAO dao = transaction.createDaoImpl(UserDAO.class);
        try {
            if (user.getId() != null) {
                if (user.getPassword() != null) {
                    user.setPassword(mdFiveMethod(user.getPassword()));
                } else {
                    User oldUser = dao.read(user.getId());
                    user.setPassword(mdFiveMethod(oldUser.getPassword()));
                }
                dao.update(user, transaction);
            } else {
                user.setPassword(mdFiveMethod(user.getPassword()));
                user.setId(dao.create(user, transaction));
            }
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
        }
    }

    @Override
    public User findByLogin(String login) throws ConstantException {
        UserDAO dao = transaction.createDaoImpl(UserDAO.class);
        return dao.read(login);
    }

    @Override
    public List<User> findByRole(Role role) throws ConstantException {
        UserDAO dao = transaction.createDaoImpl(UserDAO.class);
        return dao.readByRole(role);
    }

    @Override
    public void delete(Integer id)
            throws ClassNotFoundException, ConstantException {
        UserDAO dao = transaction.createDaoImpl(UserDAO.class);
        dao.delete(id);
    }

    @Override
    public String mdFiveMethod(String st) throws ConstantException {
        byte[] digest = new byte[0];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new ConstantException();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        StringBuilder mdHex = new StringBuilder(bigInt.toString(16).toUpperCase());

        while( mdHex.length() < 32 ){
            mdHex.insert(0, "0");
        }

        return mdHex.toString();
    }
}
