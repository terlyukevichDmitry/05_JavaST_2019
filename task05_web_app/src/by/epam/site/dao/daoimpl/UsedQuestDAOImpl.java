package by.epam.site.dao.daoimpl;

import by.epam.site.dao.daointerfaces.UsedQuestDAO;
import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.entity.*;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsedQuestDAOImpl extends AbstractDAOImpl implements UsedQuestDAO {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(UsedQuestDAOImpl.class);

    private static final String DB_SELECT_ALL = "SELECT `id`, `date`,"
            + " `client_id`, `quest_place_id`, `control` FROM `used_quest`";

    private static final String DB_DELETE = "DELETE FROM `used_quest`"
            + " WHERE `id` = ?";
    private static final String DB_DELETE_BY_PARAMETERS = "DELETE FROM"
            + " `used_quest` WHERE `id` = ? AND `client_id` = ?";

    private static final String DB_USED_QUEST_CREATE = "INSERT INTO "
            + "`used_quest` (`date`, `client_id`, `quest_place_id`, `control`) "
            + "VALUES (?, ?, ?, ?)";

    private static final String DB_USED_QUEST_UPDATE = "UPDATE `used_quest` "
            + "SET `date` " + "= ?, `client_id` = ?, `quest_place_id` = ?, " +
            "`control` = ? WHERE `id` = ?";

    private static final String DB_FIND_BY_CLIENT_ID =
            "SELECT `id`, `date`, `quest_place_id`, `control` FROM "
                    + "`used_quest` WHERE `client_id` = ?";
    private static final String DB_FIND_BY_ID =
            "SELECT `client_id`, `date`, `quest_place_id`, `control` FROM "
                    + "`used_quest` WHERE `id` = ?";


    @Override
    public List<UsedQuest> readAll() throws ConstantException {
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery(DB_SELECT_ALL)) {
            List<UsedQuest> usedQuestList = new ArrayList<>();
            while (resultSet.next()) {
                UsedQuest usedQuest = new UsedQuest();
                usedQuest.setId(resultSet.getInt("id"));
                Date date = resultSet.getDate("date");
                LocalDate localDate
                        = new java.sql.Date(date.getTime()).toLocalDate();
                usedQuest.setDate(localDate);
                int clientId = resultSet.getInt("client_id");
                if(!resultSet.wasNull()) {
                    Client client = new Client();
                    client.setId(clientId);
                    usedQuest.setClient(client);
                }
                int questPlaceId
                        = resultSet.getInt("quest_place_id");
                if(!resultSet.wasNull()) {
                    QuestPlace questPlace = new QuestPlace();
                    questPlace.setId(questPlaceId);
                    usedQuest.setQuestPlace(questPlace);
                }
                usedQuest.setControl(
                        resultSet.getBoolean("control"));
                usedQuestList.add(usedQuest);
            }
            return usedQuestList;
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
    public Integer create(final UsedQuest usedQuest,
                          final SqlTransaction transaction)
            throws ConstantException, SQLException {
        connection.setAutoCommit(false);
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_USED_QUEST_CREATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            Date date = java.sql.Date.valueOf(usedQuest.getDate());
            statement.setDate(1, date);
            statement.setInt(2, usedQuest.getClient().getId());
            statement.setInt(3,
                    usedQuest.getQuestPlace().getQuest().getId());
            statement.setBoolean(4, usedQuest.getControl());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                transaction.commit();
                return resultSet.getInt(1);
            } else {
                transaction.rollback();
                LOGGER.error("There is no autoincremented "
                        + "index after trying to add record into table "
                        + "`used_quest`");
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
    public UsedQuest update(final UsedQuest usedQuest,
                            final SqlTransaction transaction)
            throws ConstantException {
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_USED_QUEST_UPDATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            Date date = java.sql.Date.valueOf(usedQuest.getDate());
            statement.setDate(1, date);
            statement.setInt(2, usedQuest.getClient().getId());
            statement.setInt(3, usedQuest.getQuestPlace().getId());
            statement.setBoolean(4, usedQuest.getControl());
            statement.setInt(5, usedQuest.getId());
            statement.executeUpdate();
            transaction.commit();
            return usedQuest;
        } catch (SQLException e) {
            transaction.rollback();
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
    }

    @Override
    public List<UsedQuest> read(final Integer id) throws ConstantException {
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_FIND_BY_CLIENT_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<UsedQuest> usedQuestList = new ArrayList<>();
            UsedQuest usedQuest = null;
            while (resultSet.next()) {
                usedQuest = new UsedQuest();
                usedQuest.setId(resultSet.getInt("id"));
                Date date = resultSet.getDate("date");
                LocalDate localDate
                        = new java.sql.Date(date.getTime()).toLocalDate();
                usedQuest.setDate(localDate);
                if(!resultSet.wasNull()) {
                    Client client = new Client();
                    client.setId(id);
                    usedQuest.setClient(client);
                }
                int questPlaceId
                        = resultSet.getInt("quest_place_id");
                if(!resultSet.wasNull()) {
                    QuestPlace questPlace = new QuestPlace();
                    questPlace.setId(questPlaceId);
                    usedQuest.setQuestPlace(questPlace);
                }
                usedQuest.setControl(
                        resultSet.getBoolean("control"));
                usedQuestList.add(usedQuest);
            }
            return usedQuestList;
        } catch (SQLException exception) {
            throw new ConstantException(exception);
        }
    }

    @Override
    public void delete(final Integer clientId, final Integer usedQuestId)
            throws ConstantException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(DB_DELETE_BY_PARAMETERS)) {
            statement.setInt(1, usedQuestId);
            statement.setInt(2, clientId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public UsedQuest readById(Integer usedQuestId) throws ConstantException {
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_FIND_BY_ID)) {
            statement.setInt(1, usedQuestId);
            ResultSet resultSet = statement.executeQuery();
            UsedQuest usedQuest = null;
            if (resultSet.next()) {
                usedQuest = new UsedQuest();
                usedQuest.setId(usedQuestId);
                Date date = resultSet.getDate("date");
                LocalDate localDate
                        = new java.sql.Date(date.getTime()).toLocalDate();
                usedQuest.setDate(localDate);
                int clientId
                        = resultSet.getInt("client_id");
                if(!resultSet.wasNull()) {
                    Client client = new Client();
                    client.setId(clientId);
                    usedQuest.setClient(client);
                }
                int questPlaceId
                        = resultSet.getInt("quest_place_id");
                if(!resultSet.wasNull()) {
                    QuestPlace questPlace = new QuestPlace();
                    questPlace.setId(questPlaceId);
                    usedQuest.setQuestPlace(questPlace);
                }
                usedQuest.setControl(
                        resultSet.getBoolean("control"));
            }
            return usedQuest;
        } catch (SQLException exception) {
            throw new ConstantException(exception);
        }
    }
}
