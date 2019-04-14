package by.epam.site.dao;

import by.epam.site.entity.AuthorQuest;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorQuestDAO extends AbstractDAO<AuthorQuest> {
    private static final String DB_SELECT_ALL = "SELECT `id`, `name`, "
            + "`surname`, `patronymic`, `year_of_birth`, `year_of_death` "
            + "FROM `author_quest`";
    private static final String DB_DELETE = "DELETE FROM `author_quest`"
            + "WHERE `id`" + " = ?";
    private static final String DB_AUTHOR_CREATE = "INSERT INTO `author_quest` "
            + "(`name`, `surname`, `patronymic`, `year_of_birth`, "
            + "`year_of_death`)" + " VALUES (?, ?, ?, ?, ?)";
    private static final String DB_AUTHOR_UPDATE = "UPDATE `author_quest` SET"
            + " `name` "
            + "= ?, `surname` = ?, `patronymic` = ?, " + "`year_of_birth` = ?,"
            + " `year_of_death` = ? WHERE `id` = ?";

    @Override
    public List<AuthorQuest> readAll() throws SQLException, ConstantException, ClassNotFoundException {
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DB_SELECT_ALL)) {

            List<AuthorQuest> authorQuests = new ArrayList<>();
            while (resultSet.next()) {
                AuthorQuest authorQuest = new AuthorQuest();
                authorQuest.setId(resultSet.getInt("id"));
                authorQuest.setName(resultSet.getString("name"));
                authorQuest.setSurname(resultSet.getString("surname"));
                authorQuest.setPatronymic(resultSet.getString(
                        "patronymic"));
                authorQuest.setYearOfBirth(resultSet.getInt(
                        "year_of_birth"));
                authorQuest.setYearOfDeath(resultSet.getInt(
                        "year_of_death"));
                authorQuests.add(authorQuest);
            }
            return authorQuests;
        } catch (SQLException exception) {
            throw new ConstantException(exception);
        }
    }

    @Override
    public void delete(Integer id) throws ConstantException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(DB_DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(final AuthorQuest authorQuest) throws ConstantException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(DB_AUTHOR_CREATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, authorQuest.getName());
            statement.setString(2, authorQuest.getSurname());
            statement.setString(3, authorQuest.getPatronymic());
            statement.setInt(4, authorQuest.getYearOfBirth());
            statement.setInt(5, authorQuest.getYearOfDeath());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AuthorQuest update(final AuthorQuest authorQuest)
            throws ConstantException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(DB_AUTHOR_UPDATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, authorQuest.getName());
            statement.setString(2, authorQuest.getSurname());
            statement.setString(3, authorQuest.getPatronymic());
            statement.setInt(4, authorQuest.getYearOfBirth());
            statement.setInt(5, authorQuest.getYearOfDeath());
            statement.setInt(6, authorQuest.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return authorQuest;
    }
}
