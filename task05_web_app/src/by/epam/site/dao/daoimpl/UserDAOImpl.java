package by.epam.site.dao.daoimpl;

import by.epam.site.dao.daointerfaces.UserDAO;
import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl extends AbstractDAOImpl implements UserDAO {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(UserDAOImpl.class);

    private static final String DB_SELECT_ALL = "SELECT `id`, `login`,"
            + " `password`, `role` FROM `user`";
    private static final String DB_DELETE = "DELETE FROM `user` WHERE `id` = ?"
            + " AND `role` = ?";
    private static final String DB_DELETE_WITH_ONE_PARAM = "DELETE FROM `user`"
            + " WHERE `id` = ?";
    private static final String DB_USER_CREATE = "INSERT INTO `user` "
            + "(`login`, `password`, `role`) VALUES (?, ?, ?)";
    private static final String DB_USER_UPDATE = "UPDATE `user` SET `login` "
            + "= ?, `password` = ?, `role` = ? WHERE `id` = ?";
    private static final String DB_USER = "SELECT `id`, `role` FROM `user` "
            + "WHERE `login` = ? AND `password` = ?";
    private static final String DB_FIND_BY_ID = "SELECT `login`, `password`, "
            + "`role` FROM `user` WHERE `id` = ?";
    private static final String DB_FIND_BY_LOGIN
            = "SELECT id FROM user WHERE login = ?";
    private static final String DB_FIND_BY_ROLE
            = "SELECT `id`, `login`, `password` FROM user WHERE `role` = ?";

    @Override
    public List<User> readAll()
            throws ConstantException {
        try(Connection connection = getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(DB_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery(DB_SELECT_ALL)) {
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.getByIdentity(resultSet.getInt(
                        "role")));
                userList.add(user);
            }
            return userList;
        } catch (SQLException exception) {
            throw new ConstantException(exception);
        }
    }

    @Override
    public void delete(Integer id)
            throws ConstantException {
        try (PreparedStatement statement
                     = connection.prepareStatement(DB_DELETE_WITH_ONE_PARAM)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);

        }
    }

    @Override
    public void deleteByRole(final Integer id, final Role role)
            throws ConstantException {
        try (PreparedStatement statement
                = connection.prepareStatement(DB_DELETE)) {
            statement.setInt(1, id);
            statement.setInt(2, role.getIdentity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public Integer create(final User user, final SqlTransaction transaction)
            throws ConstantException, SQLException {
        connection.setAutoCommit(false);
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_USER_CREATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getIdentity());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            transaction.commit();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                transaction.rollback();
                throw new ConstantException();
            }
        } catch (SQLException e) {
            transaction.rollback();
            throw new ConstantException(e);
        }
    }

    @Override
    public User update(final User user, final SqlTransaction transaction)
            throws ConstantException, SQLException {
        connection.setAutoCommit(false);
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_USER_UPDATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getIdentity());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
            transaction.commit();
        } catch (SQLException e) {
            transaction.rollback();
            throw new ConstantException(e);
        }
        return user;
    }

    @Override
    public User read(String login, String password) throws ConstantException {
        try(PreparedStatement statement
                    = getConnection().prepareStatement(DB_USER)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            if(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(Role.getByIdentity(resultSet.getInt(
                        "role")));
            }
            resultSet.close();
            return user;
        } catch(SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public User read(Integer id) throws ConstantException {
        try( PreparedStatement statement
                     = connection.prepareStatement(DB_FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            if(resultSet.next()) {
                user = new User();
                user.setId(id);
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.getByIdentity(resultSet.getInt(
                        "role")));
            }
            resultSet.close();
            return user;
        } catch(SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public User read(final String login) throws ConstantException {
        try(PreparedStatement statement
                    = getConnection().prepareStatement(DB_FIND_BY_LOGIN)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            if(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(login);
            }
            resultSet.close();
            return user;
        } catch(SQLException e) {
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
    }

    @Override
    public List<User> readByRole(final Role role) throws ConstantException {
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_FIND_BY_ROLE)) {
            statement.setInt(1, role.getIdentity());
            ResultSet resultSet = statement.executeQuery();
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(role);
                userList.add(user);
            }
            return userList;
        } catch (SQLException exception) {
            throw new ConstantException(exception);
        }
    }
}
