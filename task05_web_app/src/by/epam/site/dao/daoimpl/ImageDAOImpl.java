package by.epam.site.dao.daoimpl;

import by.epam.site.dao.daointerfaces.ImageDAO;
import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.entity.Image;
import by.epam.site.exception.ConstantException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImageDAOImpl extends AbstractDAOImpl implements ImageDAO {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(ImageDAOImpl.class);

    private static final String DB_SELECT_ALL = "SELECT `id`, `imageAddress` FROM `image`";
    private static final String DB_DELETE = "DELETE FROM `image` WHERE `id`"
            + " = ?";
    private static final String DB_IMAGE_CREATE = "INSERT INTO `image` "
            + "(`filePath`)"
            + " VALUES (?)";
    private static final String DB_IMAGE_UPDATE = "UPDATE `image` SET " +
            "`filePath` = ? WHERE `id` = ?";
    @Override
    public List<Image> readAll() throws ConstantException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DB_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery()) {

            List<Image> images = new ArrayList<>();
            while (resultSet.next()) {
                Image image = new Image();
                image.setId(resultSet.getInt("id"));
                image.setFilePath(resultSet.getString("imageAddress"));
                images.add(image);
            }
            return images;
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
    public Integer create(Image image, final SqlTransaction transaction)
            throws ConstantException {
        try(Connection connection = getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(DB_IMAGE_CREATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            statement.setString(1, image.getFilePath());
            statement.executeUpdate();
            transaction.commit();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                transaction.rollback();
                LOGGER.error("There is no autoincremented index after "
                        + "trying to add record into table `image`");
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
    public Image update(final Image image, final SqlTransaction transaction)
            throws ConstantException {
        try(Connection connection = getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(DB_IMAGE_UPDATE,
                    Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            statement.setString(1, image.getFilePath());
            statement.setInt(2, image.getId());
            statement.executeUpdate();
            transaction.commit();
        } catch (SQLException e) {
            transaction.rollback();
            LOGGER.error("It is impossible to turn off " +
                    "autocommiting for database connection", e);
            throw new ConstantException(e);
        }
        return image;
    }
}
