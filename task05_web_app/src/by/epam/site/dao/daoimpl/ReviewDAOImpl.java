package by.epam.site.dao.daoimpl;

import by.epam.site.dao.ReviewDAO;
import by.epam.site.entity.Client;
import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl extends AbstractDAOImpl<Review> implements ReviewDAO {

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
    public List<Review> readAll() throws SQLException, ConstantException, ClassNotFoundException {
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
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
    public void create(final Review review) throws ConstantException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(DB_REVIEW_CREATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, review.getMessage());
            statement.setDate(2, (java.sql.Date) review.getDate());
            statement.setInt(3, review.getClient().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
    }

    @Override
    public Review update(final Review review) throws ConstantException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(DB_REVIEW_UPDATE,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, review.getMessage());
            statement.setDate(2, (java.sql.Date) review.getDate());
            statement.setInt(3, review.getClient().getId());
            statement.setInt(4, review.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ConstantException(e);
        }
        return review;
    }

    @Override
    public void initializeClient(Review review) throws ConstantException, ClassNotFoundException {
        final String DB_CLIENT_SELECT = "SELECT `name`, `surname`, `patronymic`, `years`, `email`, `phone` FROM `client` "
                + "WHERE `id` = " + review.getClient().getId();
        try {
            Connection c = getConnection();
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery(DB_CLIENT_SELECT);

            if(resultSet.next()) {
                review.getClient().setName(resultSet.getString(
                        "name"));
                review.getClient().setSurname(resultSet.getString(
                        "surname"));
                review.getClient().setPatronymic(resultSet.getString(
                        "patronymic"));
                review.getClient().setYears(resultSet.getInt(
                        "years"));
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
