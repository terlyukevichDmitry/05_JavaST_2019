package by.epam.site.dao.daoimpl;

import by.epam.site.dao.daointerfaces.QuestPlaceDAO;
import by.epam.site.entity.Image;
import by.epam.site.entity.Quest;
import by.epam.site.entity.QuestPlace;
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
    private static final String DB_DELETE = "DELETE FROM `quest_place`"
            + " WHERE `id` = ?";
    private static final String DB_QUEST_PLACE_CREATE = "INSERT INTO "
            + "`quest_place` (`name`, `address`, `phone`, `image_id`, `quest_id`) "
            + "VALUES (?, ?, ?, ?, ?)";
    private static final String DB_QUEST_PLACE_UPDATE = "UPDATE `quest_place` "
            + "SET `name` " + "= ?, `address` = ?, `phone` = ?, `image_id` = "
            + "?, `quest_id` = ? WHERE `id` = ?";

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
    public Integer create(QuestPlace questPlace) throws ConstantException {
        ResultSet resultSet = null;
        try(Connection connection = getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(DB_QUEST_PLACE_CREATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, questPlace.getName());
            statement.setString(2, questPlace.getAddress());
            statement.setString(3, questPlace.getPhone());
            statement.setInt(4, questPlace.getQuest().getId());
            statement.setInt(5, questPlace.getImage().getId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                LOGGER.error("There is no autoincremented index after trying to add record into table `users`");
                throw new ConstantException();
            }
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public QuestPlace update(QuestPlace questPlace) throws ConstantException {
        try(Connection connection = getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(DB_QUEST_PLACE_UPDATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, questPlace.getName());
            statement.setString(2, questPlace.getAddress());
            statement.setString(3, questPlace.getPhone());
            statement.setInt(4, questPlace.getImage().getId());
            statement.setInt(5, questPlace.getQuest().getId());
            statement.setInt(6, questPlace.getId());
            statement.executeUpdate();
            return questPlace;
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }
}
