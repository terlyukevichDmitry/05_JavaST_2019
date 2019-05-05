package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daointerfaces.UserDAO;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserServiceImpl extends ServiceImpl implements UserService {
    private static Logger logger
            = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public User findByLoginAndPassword(String login, String password)
            throws ConstantException {
        UserDAO dao = transaction.createDaoImpl(UserDAO.class);
        return dao.read(login, password);
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(Integer id) {

    }

    public String mdFiveMethod(String st) throws ConstantException {
        byte[] digest = new byte[0];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            logger.warn("NoSuchAlgorithmException", e);
            throw new ConstantException();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        StringBuilder mdHex = new StringBuilder(bigInt.toString(16));

        while( mdHex.length() < 32 ){
            mdHex.insert(0, "0");
        }

        return mdHex.toString();
    }
}
