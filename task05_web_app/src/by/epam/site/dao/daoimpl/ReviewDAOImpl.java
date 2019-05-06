package by.epam.site.dao.daoimpl;

import by.epam.site.dao.daointerfaces.ReviewDAO;
import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.entity.Client;
import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl extends AbstractDAOImpl implements ReviewDAO {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(ReviewDAOImpl.class);

    private static final String DB_SELECT_ALL = "SELECT `id`, `message`, "
            + "`date`, `client_id` FROM `review`";
    private static final String DB_DELETE = "DELETE FROM `review` WHERE `id`"
            + " = ?";
    private static final String DB_REVIEW_CREATE = "INSERT INTO `review` "
            + "(`message`, `date`, `client_id`)"
            + " VALUES (?, ?, ?)";
    private static final String DB_REVIEW_UPDATE = "UPDATE `review` SET `message` "
            + "= ?, `date` = ?, `client_id` = ? WHERE `id` = ?";
    @Override
    public List<Review> readAll() throws ConstantException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DB_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery(DB_SELECT_ALL)) {

            List<Review> reviews = new ArrayList<>();
            while (resultSet.next()) {
                Review review = new Review();
                review.setId(resultSet.getInt("id"));
                review.setMessage(resultSet.getString("message"));
                review.setDate(resultSet.getDate("date"));
                Client client = new Client();
                client.setId(resultSet.getInt("client_id"));
                if(!resultSet.wasNull()) {
                    review.setClient(client);
                }
                reviews.add(review);
            }
            return reviews;
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
    public Integer create(final Review review, final SqlTransaction transaction)
            throws ConstantException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(DB_REVIEW_CREATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            statement.setString(1, review.getMessage());
            statement.setDate(2, (java.sql.Date) review.getDate());
            statement.setInt(3, review.getClient().getId());
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
            throws ConstantException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(DB_REVIEW_UPDATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            statement.setString(1, review.getMessage());
            statement.setDate(2, (java.sql.Date) review.getDate());
            statement.setInt(3, review.getClient().getId());
            statement.setInt(4, review.getId());
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
    public void initializeClient(Review review) throws ConstantException, ClassNotFoundException {
        final String DB_CLIENT_SELECT = "SELECT `name`, `surname`, `patronymic`, `years`, `email`, `phone` FROM `client` "
                + "WHERE `id` = " + review.getClient().getId();
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DB_CLIENT_SELECT);
            ResultSet resultSet = statement.executeQuery(DB_CLIENT_SELECT);

            if(resultSet.next()) {
                review.getClient().setName(resultSet.getString(
                        "name"));
                review.getClient().setSurname(resultSet.getString(
                        "surname"));
                review.getClient().setPatronymic(resultSet.getString(
                        "patronymic"));
                review.getClient().setDate_of_birth(resultSet.getDate(
                        "date_of_birth"));
                review.getClient().setEmail(resultSet.getString(
                        "email"));
                review.getClient().setPhone(resultSet.getString(
                        "phone"));
            }
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }
}
