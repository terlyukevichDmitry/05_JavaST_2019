package by.epam.site.dao;

import by.epam.site.entity.Client;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<User>{
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

    @Override
    public List<User> readAll() throws ConstantException, ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            assert false;
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(DB_SELECT_ALL);
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
        } finally {
            try {
                assert false;
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException | NullPointerException ignored) {}
        }
    }

    @Override
    public void delete(Integer id) throws ConstantException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(DB_DELETE_WITH_ONE_PARAM)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }

    // Method in this class.
    public void delete(final Integer id, final Role role) throws ConstantException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                = connection.prepareStatement(DB_DELETE)) {
            statement.setInt(1, id);
            statement.setInt(2, role.getIdentity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public void create(final User user) throws ConstantException, ClassNotFoundException {
        try(Connection connection = getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(DB_USER_CREATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getIdentity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public User update(final User user) throws ConstantException, ClassNotFoundException {
        try(Connection connection = getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(DB_USER_UPDATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getIdentity());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
        return user;
    }
}
