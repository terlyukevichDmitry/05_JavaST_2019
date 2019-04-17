package by.epam.site.dao.daoimpl;

import by.epam.site.dao.QuestDAO;
import by.epam.site.entity.AuthorQuest;
import by.epam.site.entity.Quest;
import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestDAOImpl extends AbstractDAOImpl<Quest> implements QuestDAO {

    private static final String DB_SELECT_ALL = "SELECT `id`, `title`, "
            + "`level`, `max_people`, `author_id`, `review_id` FROM `quest`";
    private static final String DB_DELETE = "DELETE FROM `quest` WHERE `id`"
            + " = ?";
    private static final String DB_QUEST_CREATE = "INSERT INTO `quest` "
            + "(`title`, `level`, `max_people`, `author_id`, `review_id`)"
            + " VALUES (?, ?, ?, ?, ?)";
    private static final String DB_QUEST_UPDATE = "UPDATE `quest` SET `title` "
            + "= ?, `level` = ?, `max_people` = ?, " + "`author_id` = ?, "
            + "`review_id` = ? WHERE `id` = ?";

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
                AuthorQuest authorQuest = new AuthorQuest();
                authorQuest.setId(resultSet.getInt("author_id"));
                if(!resultSet.wasNull()) {
                    quest.setAuthorQuest(authorQuest);
                }
                Review review = new Review();
                review.setId(resultSet.getInt("review_id"));
                if(!resultSet.wasNull()) {
                    quest.setReviewList(review);
                }
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
            statement.setInt(2, quest.getAuthorQuest().getId());
            statement.setInt(3, quest.getLevel());
            statement.setInt(4, quest.getMaxPeople());
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
            statement.setInt(3, quest.getAuthorQuest().getId());
            statement.setString(4, quest.getTitle());
            statement.setInt(5, quest.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
        return quest;
    }

    @Override
    public void initializeAuthorQuest(Quest quest) throws ConstantException, ClassNotFoundException {
        final String DB_AUTHOR_SELECT = "SELECT `name`, `surname`, "
                + "`patronymic`, "
                + "`year_of_birth`, `year_of_death` FROM `author_quest` "
                + "WHERE `id` = " + quest.getAuthorQuest().getId();
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DB_AUTHOR_SELECT);
            ResultSet resultSet1 = statement.executeQuery();

            if(resultSet1.next()) {
                quest.getAuthorQuest().setName(resultSet1.getString("name"));

                quest.getAuthorQuest().setSurname(resultSet1.getString("surname"));

                quest.getAuthorQuest().setPatronymic(resultSet1.getString(
                        "patronymic"));
                quest.getAuthorQuest().setYearOfBirth(resultSet1.getInt(
                        "year_of_birth"));
                quest.getAuthorQuest().setYearOfDeath(resultSet1.getInt(
                        "year_of_death"));
            }
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }
}
