package by.epam.site.dao.daoimpl;

import by.epam.site.entity.Quest;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestDAOImpl extends AbstractDAOImpl<Quest> {

    private static final String DB_SELECT_ALL = "SELECT `id`, `title`, "
            + "`level`, `max_people` FROM `quest`";
    private static final String DB_DELETE = "DELETE FROM `quest` WHERE `id`"
            + " = ?";
    private static final String DB_QUEST_CREATE = "INSERT INTO `quest` "
            + "(`title`, `level`, `max_people`)"
            + " VALUES (?, ?, ?)";
    private static final String DB_QUEST_UPDATE = "UPDATE `quest` SET `title` "
            + "= ?, `level` = ?, `max_people` = ? WHERE `id` = ?";

    @Override
    public List<Quest> readAll()
            throws ConstantException, ClassNotFoundException {

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
                quests.add(quest);
            }
            return quests;
        } catch (SQLException exception) {
            throw new ConstantException(exception);
        }
    }

    @Override
    public void delete(Integer id) throws ConstantException, ClassNotFoundException {
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
    public void create(Quest quest) throws ConstantException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(DB_QUEST_CREATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, quest.getTitle());
            statement.setInt(2, quest.getLevel());
            statement.setInt(3, quest.getMaxPeople());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public Quest update(Quest quest) throws ConstantException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(DB_QUEST_UPDATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, quest.getMaxPeople());
            statement.setInt(2, quest.getLevel());
            statement.setString(3, quest.getTitle());
            statement.setInt(4, quest.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
        return quest;
    }
}
