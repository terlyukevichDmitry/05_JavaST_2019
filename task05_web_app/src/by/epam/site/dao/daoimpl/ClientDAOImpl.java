package by.epam.site.dao.daoimpl;

import by.epam.site.dao.daointerfaces.ClientDAO;
import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.entity.Client;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl extends AbstractDAOImpl implements ClientDAO {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(ClientDAOImpl.class);

    private static final String DB_SELECT_ALL = "SELECT `id`, `name`, "
            + "`surname`, `patronymic`, `dateOfBirth`, `email`, "
            + "`phone`, `imageAddress` FROM `client`";
    private static final String DB_DELETE = "DELETE FROM `client` WHERE `id`"
            + " = ?";
    private static final String DB_CLIENT_CREATE = "INSERT INTO `client` "
            + "(`name`, `surname`, `patronymic`, `dateOfBirth`, `email`, `phone`, `imageAddress`)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String DB_CLIENT_UPDATE = "UPDATE `client` SET `name` "
            + "= ?, `surname` = ?, `patronymic` = ?, " + "`dateOfBirth` = ?, "
            + "`email` = ?, `phone` = ?, `imageAddress` = ? WHERE `id` = ?";
    private static final String DB_FIND_BY_ID = "SELECT `name`, `surname`, " +
            "`patronymic`, `dateOfBirth`, `email`, `phone`, `imageAddress`"
            + " FROM `client` WHERE `id` = ?";

    @Override
    public List<Client> readAll() throws ConstantException {
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
                Date date = resultSet.getDate("dateOfBirth");
                LocalDate localDate
                        = new java.sql.Date(date.getTime()).toLocalDate();
                client.setDateOfBirth(localDate);
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getString("phone"));
                client.setFilePath(resultSet.getString(
                        "imageAddress"));
                clients.add(client);
            }
            return clients;
        } catch (SQLException exception) {
            throw new ConstantException(exception);
        }
    }

    @Override
    public void delete(final Integer id) throws ConstantException {
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
    public Integer create(Client client, final SqlTransaction transaction)
            throws ConstantException, SQLException {
        connection.setAutoCommit(false);
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_CLIENT_CREATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setString(3, client.getPatronymic());
            Date date = java.sql.Date.valueOf(client.getDateOfBirth());
            statement.setDate(4, date);
            statement.setString(5, client.getEmail());
            statement.setString(6, client.getPhone());
            statement.setString(7, "images/first.image");
            statement.executeUpdate();
            transaction.commit();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                transaction.rollback();
                LOGGER.error("There is no autoincremented index after "
                        + "trying to add record into table `client`");
                throw new ConstantException();
            }
        } catch (SQLException e) {
            transaction.rollback();
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
    }

    @Override
    public Client update(final Client client, final SqlTransaction transaction)
            throws ConstantException {
        try(Connection connection = getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(DB_CLIENT_UPDATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setString(3, client.getPatronymic());
            Date date = java.sql.Date.valueOf(client.getDateOfBirth());
            statement.setDate(4, date);
            statement.setString(5, client.getEmail());
            statement.setString(6, client.getPhone());
            statement.setString(7, client.getFilePath());
            statement.setInt(8, client.getId());
            statement.executeUpdate();
            transaction.commit();
        } catch (SQLException e) {
            transaction.rollback();
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
        return client;
    }

    @Override
    public Client read(final Integer id) throws ConstantException {
        try(PreparedStatement statement
                    = getConnection().prepareStatement(DB_FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Client client = null;
            if(resultSet.next()) {
                client = new Client();
                client.setId(id);
                client.setName(resultSet.getString("name"));
                client.setSurname(resultSet.getString("surname"));
                client.setPatronymic(resultSet.getString(
                        "patronymic"));
                Date date = resultSet.getDate(
                        "dateOfBirth");
                LocalDate localDate
                        = new java.sql.Date(date.getTime()).toLocalDate();
                client.setDateOfBirth(localDate);
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getString("phone"));
                client.setFilePath(resultSet.getString("imageAddress"));
            }
            return client;
        } catch(SQLException e) {
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
    }
}
