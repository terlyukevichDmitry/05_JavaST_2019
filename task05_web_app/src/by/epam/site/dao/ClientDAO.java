package by.epam.site.dao;

import by.epam.site.entity.Client;
import by.epam.site.exception.ConstantException;

import java.sql.SQLException;
import java.util.List;

public class ClientDAO implements AbstractDAO<Client> {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/quest_bd?"
            + "useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_LOGIN = "quest_user";
    private static final String DB_PASSWORD = "quest_password";
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
    public List<Client> readAll() throws SQLException, ConstantException {
        return null;
    }

    @Override
    public void delete(Integer id) throws ConstantException {

    }

    @Override
    public void create(Client entity) throws ConstantException {

    }

    @Override
    public Client update(Client entity) throws ConstantException {
        return null;
    }
}
