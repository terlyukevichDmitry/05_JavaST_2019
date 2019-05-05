package by.epam.site.dao.daoimpl;

import by.epam.site.dao.daointerfaces.UsedQuestDAO;
import by.epam.site.entity.*;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsedQuestDAOImpl extends AbstractDAOImpl implements UsedQuestDAO {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(UsedQuestDAOImpl.class);
    private static final String DB_SELECT_ALL = "SELECT `id`, `date`,"
            + " `client_id`, `quest_place_id` FROM `used_quest`";
    private static final String DB_DELETE = "DELETE FROM `used_quest`"
            + " WHERE `id` = ?";
    private static final String DB_USED_QUEST_CREATE = "INSERT INTO "
            + "`used_quest` (`date`, `client_id`, `used_quest_id`) "
            + "VALUES (?, ?, ?)";
    private static final String DB_USED_QUEST_UPDATE = "UPDATE `used_quest` "
            + "SET `date` " + "= ?, `client_id` = ?, `used_quest_id` = ? "
            + "WHERE `id` = ?";


    @Override
    public List<UsedQuest> readAll() throws ConstantException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DB_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery(DB_SELECT_ALL)) {
            List<UsedQuest> usedQuestList = new ArrayList<>();
            while (resultSet.next()) {
                UsedQuest usedQuest = new UsedQuest();
                usedQuest.setId(resultSet.getInt("id"));
                usedQuest.setDate(resultSet.getDate("date"));
                int clientId = resultSet.getInt("client_id");
                if(!resultSet.wasNull()) {
                    Client client = new Client();
                    client.setId(clientId);
                    usedQuest.setClient(client);
                }
                int questPlaceId = resultSet.getInt("quest_place_id");
                if(!resultSet.wasNull()) {
                    QuestPlace questPlace = new QuestPlace();
                    questPlace.setId(questPlaceId);
                    usedQuest.setQuestPlace(questPlace);
                }
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
    public Integer create(UsedQuest usedQuest) throws ConstantException {
        ResultSet resultSet = null;
        try(Connection connection = getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(DB_USED_QUEST_CREATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, (Date) usedQuest.getDate());
            statement.setInt(2, usedQuest.getClient().getId());
            statement.setInt(3,
                    usedQuest.getQuestPlace().getQuest().getId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                LOGGER.error("There is no autoincremented " +
                        "index after trying to add record into table `users`");
                throw new ConstantException();
            }
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public UsedQuest update(UsedQuest usedQuest) throws ConstantException {
        try(Connection connection = getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(DB_USED_QUEST_UPDATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, (Date) usedQuest.getDate());
            statement.setInt(2, usedQuest.getClient().getId());
            statement.setInt(3, usedQuest.getQuestPlace().getId());
            statement.setInt(4, usedQuest.getId());
            statement.executeUpdate();
            return usedQuest;
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }
}
