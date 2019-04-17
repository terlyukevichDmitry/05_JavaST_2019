package by.epam.site.dao.daoimpl;

import by.epam.site.dao.ClientDAO;
import by.epam.site.dao.daoimpl.AbstractDAOImpl;
import by.epam.site.entity.Client;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl extends AbstractDAOImpl<Client> implements ClientDAO {
    private static final String DB_SELECT_ALL = "SELECT `id`, `name`, "
            + "`surname`, `patronymic`, `years`, `email`, "
            + "`phone` FROM `client`";
    private static final String DB_DELETE = "DELETE FROM `client` WHERE `id`"
            + " = ?";
    private static final String DB_CLIENT_CREATE = "INSERT INTO `client` "
            + "(`name`, `surname`, `patronymic`, `years`, `email`, `phone`)"
            + " VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DB_CLIENT_UPDATE = "UPDATE `client` SET `name` "
            + "= ?, `surname` = ?, `patronymic` = ?, " + "`years` = ?, "
            + "`email` = ?, `phone` = ? WHERE `id` = ?";

    @Override
    public List<Client> readAll() throws SQLException, ConstantException, ClassNotFoundException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DB_SELECT_ALL);
        ResultSet resultSet = statement.executeQuery()) {

            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setSurname(resultSet.getString("surname"));
                client.setPatronymic(resultSet.getString(
                        "patronymic"));
                client.setYears(resultSet.getInt("years"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getString("phone"));
                clients.add(client);
            }
            return clients;
        } catch (SQLException exception) {
            throw new ConstantException(exception);
        }
    }

    @Override
    public void delete(final Integer id) throws ConstantException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(DB_DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public void create(Client client) throws ConstantException, ClassNotFoundException {
        try(Connection connection = getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(DB_CLIENT_CREATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setString(3, client.getPatronymic());
            statement.setInt(4, client.getYears());
            statement.setString(5, client.getEmail());
            statement.setString(6, client.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public Client update(Client client) throws ConstantException, ClassNotFoundException {
        try(Connection connection = getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(DB_CLIENT_UPDATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setString(3, client.getPatronymic());
            statement.setInt(4, client.getYears());
            statement.setString(5, client.getEmail());
            statement.setString(6, client.getPhone());
            statement.setInt(7, client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
        return client;
    }
}
