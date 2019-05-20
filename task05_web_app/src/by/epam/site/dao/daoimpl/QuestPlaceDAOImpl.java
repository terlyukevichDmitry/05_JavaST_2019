package by.epam.site.dao.daoimpl;

import by.epam.site.dao.daointerfaces.QuestPlaceDAO;
import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.entity.*;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestPlaceDAOImpl
        extends AbstractDAOImpl implements QuestPlaceDAO {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(QuestPlaceDAOImpl.class);
    private static final String DB_SELECT_ALL = "SELECT `id`, `name`,"
            + " `address`, `phone`, `image_id`, `quest_id` FROM `quest_place`";
    private static final String DB_DELETE = "DELETE FROM `quest_place` "
            + "WHERE `id` = ?";
    private static final String DB_QUEST_PLACE_CREATE = "INSERT INTO "
            + "`quest_place` (`name`, `address`, `phone`, `image_id`, `quest_id`) "
            + "VALUES (?, ?, ?, ?, ?)";
    private static final String DB_QUEST_PLACE_UPDATE = "UPDATE `quest_place` "
            + "SET `name` " + "= ?, `address` = ?, `phone` = ?, `image_id` = "
            + "?, `quest_id` = ? WHERE `id` = ?";
    private static final String DB_SEARCH_BY_TITLE = "SELECT `id`, `address`, "
            + "`phone`, `image_id`, `quest_id` FROM `quest_place` "
            + "WHERE `name` = ?";

    private static final String DB_FIND_BY_ID
            = "SELECT `name`, `address`, `phone`, `image_id`, `quest_id` FROM `quest_place` "
            + "WHERE `id` = ?";

    @Override
    public List<QuestPlace> readAll() throws ConstantException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DB_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery(DB_SELECT_ALL)) {
            List<QuestPlace> questPlaceList = new ArrayList<>();
            while (resultSet.next()) {
                QuestPlace questPlace = new QuestPlace();
                questPlace.setId(resultSet.getInt("id"));
                questPlace.setName(resultSet.getString("name"));
                questPlace.setAddress(resultSet.getString("address"));
                questPlace.setPhone(resultSet.getString("phone"));
                int imageId = resultSet.getInt("image_id");
                if(!resultSet.wasNull()) {
                    Image image = new Image();
                    image.setId(imageId);
                    questPlace.setImage(image);
                }
                int questId = resultSet.getInt("quest_id");
                if(!resultSet.wasNull()) {
                    Quest quest = new Quest();
                    quest.setId(questId);
                    questPlace.setQuest(quest);
                }
                questPlaceList.add(questPlace);
            }
            return questPlaceList;
        } catch (SQLException exception) {
            throw new ConstantException(exception);
        }
    }

    @Override
    public void delete(Integer id) throws ConstantException {
        try (PreparedStatement statement
                     = connection.prepareStatement(DB_DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public Integer create(final QuestPlace questPlace,
                          final SqlTransaction transaction)
            throws ConstantException, SQLException {
        connection.setAutoCommit(false);
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_QUEST_PLACE_CREATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, questPlace.getName());
            statement.setString(2, questPlace.getAddress());
            statement.setString(3, questPlace.getPhone());
            statement.setInt(4, questPlace.getImage().getId());
            statement.setInt(5, questPlace.getQuest().getId());
            statement.executeUpdate();
            transaction.commit();
            ResultSet resultSet = statement.getGeneratedKeys();
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
    public QuestPlace update(final QuestPlace questPlace,
                             final SqlTransaction transaction)
            throws ConstantException, SQLException {
        connection.setAutoCommit(false);
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_QUEST_PLACE_UPDATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, questPlace.getName());
            statement.setString(2, questPlace.getAddress());
            statement.setString(3, questPlace.getPhone());
            statement.setInt(4, questPlace.getImage().getId());
            statement.setInt(5, questPlace.getQuest().getId());
            statement.setInt(6, questPlace.getId());
            statement.executeUpdate();
            transaction.commit();
            return questPlace;
        } catch (SQLException e) {
            transaction.rollback();
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
    }

    @Override
    public List<QuestPlace> read(String title) throws ConstantException {
        try(PreparedStatement statement
                    = getConnection().prepareStatement(DB_SEARCH_BY_TITLE)) {
            statement.setString(1, title.trim());
            ResultSet resultSet = statement.executeQuery();
            List<QuestPlace> questPlaceList = new ArrayList<>();
            while (resultSet.next()) {
                QuestPlace questPlace = new QuestPlace();
                questPlace.setId(resultSet.getInt("id"));
                questPlace.setName(title);
                questPlace.setAddress(resultSet.getString("address"));
                questPlace.setPhone(resultSet.getString("phone"));
                int imageId = resultSet.getInt("image_id");
                if(!resultSet.wasNull()) {
                    Image image = new Image();
                    image.setId(imageId);
                    questPlace.setImage(image);
                }
                int questId = resultSet.getInt("quest_id");
                if(!resultSet.wasNull()) {
                    Quest quest = new Quest();
                    quest.setId(questId);
                    questPlace.setQuest(quest);
                }
                questPlaceList.add(questPlace);
            }
            return questPlaceList;
        } catch (SQLException exception) {
            throw new ConstantException(exception);
        }
    }

    @Override
    public void read(final QuestPlace questPlace)
            throws ConstantException {
        try(PreparedStatement statement
                    = getConnection().prepareStatement(DB_FIND_BY_ID)) {
            statement.setInt(1, questPlace.getId());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                questPlace.setPhone(resultSet.getString("phone"));
                questPlace.setAddress(resultSet.getString(
                        "address"));
                questPlace.setName(resultSet.getString("name"));
                int imageId = resultSet.getInt("image_id");
                if(!resultSet.wasNull()) {
                    Image image = new Image();
                    image.setId(imageId);
                    questPlace.setImage(image);
                }
                int questId = resultSet.getInt("quest_id");
                if(!resultSet.wasNull()) {
                    Quest quest = new Quest();
                    quest.setId(questId);
                    questPlace.setQuest(quest);
                }
            }
        } catch(SQLException e) {
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
    }

    @Override
    public QuestPlace read(Integer id) throws ConstantException {
        try(PreparedStatement statement
                    = getConnection().prepareStatement(DB_FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            QuestPlace questPlace = null;
            while (resultSet.next()) {
                questPlace = new QuestPlace();
                questPlace.setId(id);
                questPlace.setName(resultSet.getString("name"));
                questPlace.setAddress(resultSet.getString("address"));
                questPlace.setPhone(resultSet.getString("phone"));
                int imageId = resultSet.getInt("image_id");
                if(!resultSet.wasNull()) {
                    Image image = new Image();
                    image.setId(imageId);
                    questPlace.setImage(image);
                }
                int questId = resultSet.getInt("quest_id");
                if(!resultSet.wasNull()) {
                    Quest quest = new Quest();
                    quest.setId(questId);
                    questPlace.setQuest(quest);
                }
            }
            return questPlace;
        } catch (SQLException exception) {
            throw new ConstantException(exception);
        }
    }
}
