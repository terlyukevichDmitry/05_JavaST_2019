package by.epam.site.dao.daoimpl;

import by.epam.site.dao.daointerfaces.ReviewDAO;
import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.entity.Client;
import by.epam.site.entity.QuestPlace;
import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl extends AbstractDAOImpl implements ReviewDAO {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(ReviewDAOImpl.class);

    private static final String DB_SELECT_ALL = "SELECT `id`, `message`, "
            + "`date`, `client_id`, `quest_place_id` FROM `review`";
    private static final String DB_DELETE = "DELETE FROM `review` WHERE `id`"
            + " = ?";
    private static final String DB_REVIEW_CREATE = "INSERT INTO `review` "
            + "(`message`, `date`, `client_id`, `quest_place_id`)"
            + " VALUES (?, ?, ?, ?)";
    private static final String DB_REVIEW_UPDATE = "UPDATE `review` SET `message` "
            + "= ?, `date` = ?, `client_id` = ?, `quest_place_id` = ? WHERE `id` = ?";
    private static final String DB_DELETE_BY_CLIENT_ID = "DELETE FROM `review` WHERE `client_id`"
            + " = ?";
    @Override
    public List<Review> readAll() throws ConstantException {
        try(PreparedStatement statement
                    = connection.prepareStatement(DB_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery(DB_SELECT_ALL)) {
            List<Review> reviews = new ArrayList<>();
            while (resultSet.next()) {
                Review review = new Review();
                review.setId(resultSet.getInt("id"));
                review.setMessage(resultSet.getString("message"));
                Date date = resultSet.getDate("date");
                LocalDate localDate
                        = new java.sql.Date(date.getTime()).toLocalDate();
                review.setDate(localDate);
                int clientId = resultSet.getInt("client_id");
                if(!resultSet.wasNull()) {
                    Client client = new Client();
                    client.setId(clientId);
                    review.setClient(client);
                }
                int questPlaceId
                        = resultSet.getInt("quest_place_id");
                if(!resultSet.wasNull()) {
                    QuestPlace questPlace = new QuestPlace();
                    questPlace.setId(questPlaceId);
                    review.setQuestPlace(questPlace);
                }
                reviews.add(review);
            }
            return reviews;
        } catch (SQLException exception) {
            LOGGER.error("SQLException", exception);
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
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
    }

    @Override
    public Integer create(final Review review, final SqlTransaction transaction)
            throws ConstantException, SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement
                     = connection.prepareStatement(DB_REVIEW_CREATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, review.getMessage());
            Date date = java.sql.Date.valueOf(review.getDate());
            statement.setDate(2, date);
            statement.setInt(3, review.getClient().getId());
            statement.setInt(4, review.getQuestPlace().getId());
            statement.executeUpdate();
            transaction.commit();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                transaction.rollback();
                LOGGER.error("There is no autoincremented index after "
                        + "trying to add record into table `review`");
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
    public Review update(final Review review, final SqlTransaction transaction)
            throws ConstantException, SQLException {
        connection.setAutoCommit(false);
        try (PreparedStatement statement
                     = connection.prepareStatement(DB_REVIEW_UPDATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, review.getMessage());
            Date date = java.sql.Date.valueOf(review.getDate());
            statement.setDate(2, date);
            statement.setInt(3, review.getClient().getId());
            statement.setInt(4, review.getQuestPlace().getId());
            statement.setInt(5, review.getId());
            statement.executeUpdate();
            transaction.commit();
        } catch (SQLException e) {
            transaction.rollback();
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
        return review;
    }

    @Override
    public void deleteByClientId(Integer clientId) throws ConstantException {
        try (PreparedStatement statement
                     = connection.prepareStatement(DB_DELETE_BY_CLIENT_ID)) {
            statement.setInt(1, clientId);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);
            throw new ConstantException(e);
        }
    }
}
