package by.epam.site.dao.daoimpl;

import by.epam.site.dao.daointerfaces.QuestDAO;
import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.entity.Quest;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestDAOImpl extends AbstractDAOImpl implements QuestDAO {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(QuestDAOImpl.class);

    private static final String DB_SELECT_ALL = "SELECT `id`, `title`, "
            + "`level`, `max_people`, `description` FROM `quest`";

    private static final String DB_DELETE = "DELETE FROM `quest` WHERE `id`"
            + " = ?";

    private static final String DB_QUEST_CREATE = "INSERT INTO `quest` "
            + "(`title`, `level`, `max_people`, `description`)"
            + " VALUES (?, ?, ?, ?)";

    private static final String DB_QUEST_UPDATE = "UPDATE `quest` SET `title` "
            + "= ?, `level` = ?, `max_people` = ?, `description` = ?"
            + " WHERE `id` = ?";

    private static final String DB_FIND_BY_ID
            = "SELECT `title`, `level`, `max_people`, `description` "
            + "FROM `quest` WHERE `id` = ?";
    private static final String DB_FIND_BY_TITLE
            = "SELECT `id`, `level`, `max_people`, `description` "
            + "FROM `quest` WHERE `title` = ?";

    @Override
    public List<Quest> readAll()
            throws ConstantException {

        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DB_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery(DB_SELECT_ALL)) {

            List<Quest> quests = new ArrayList<>();
            while (resultSet.next()) {
                Quest quest = new Quest();
                quest.setId(resultSet.getInt("id"));
                quest.setTitle(resultSet.getString("title"));
                quest.setLevel(resultSet.getInt("level"));
                quest.setMaxPeople(resultSet.getInt("max_people"));
                quest.setDescription(resultSet.getString(
                        "description"));
                quests.add(quest);
            }
            return quests;
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
        }
    }

    @Override
    public Integer create(final Quest quest, final SqlTransaction transaction)
            throws ConstantException, SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement
                     = connection.prepareStatement(DB_QUEST_CREATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, quest.getTitle());
            statement.setInt(2, quest.getLevel());
            statement.setInt(3, quest.getMaxPeople());
            statement.setString(4, quest.getDescription());
            statement.executeUpdate();
            transaction.commit();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                transaction.rollback();
                LOGGER.error("It is impossible to turn off " +
                        "autocommiting for database connection");
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
    public Quest update(Quest quest, SqlTransaction transaction)
            throws ConstantException, SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement
                     = connection.prepareStatement(DB_QUEST_UPDATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, quest.getTitle());
            statement.setInt(2, quest.getLevel());
            statement.setInt(3, quest.getMaxPeople());
            statement.setString(4, quest.getDescription());
            statement.setInt(5, quest.getId());
            statement.executeUpdate();
            transaction.commit();
        } catch (SQLException e) {
            transaction.rollback();
            throw new ConstantException(e);
        }
        return quest;
    }

    @Override
    public void read(final Quest quest)
            throws ConstantException {
        try(PreparedStatement statement
                    = getConnection().prepareStatement(DB_FIND_BY_ID)) {
            statement.setInt(1, quest.getId());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                quest.setTitle(resultSet.getString("title"));
                quest.setLevel(resultSet.getInt("level"));
                quest.setMaxPeople(resultSet.getInt("max_people"));
                quest.setDescription(resultSet.getString(
                        "description"));
            }
        } catch(SQLException e) {
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
    }

    @Override
    public Quest read(final String title) throws ConstantException {
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_FIND_BY_TITLE)) {
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();
            Quest quest = null;
            if(resultSet.next()) {
                quest = new Quest();
                quest.setId(resultSet.getInt("id"));
                quest.setTitle(title);
                quest.setLevel(resultSet.getInt("level"));
                quest.setMaxPeople(resultSet.getInt("max_people"));
                quest.setDescription(resultSet.getString(
                        "description"));
            }
            return quest;
        } catch(SQLException e) {
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
    }
}
