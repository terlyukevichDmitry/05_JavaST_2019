package by.epam.site.dao.daoimpl;

import by.epam.site.entity.Image;
import by.epam.site.exception.ConstantException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAOImpl extends AbstractDAOImpl<Image> {
    private static final String DB_SELECT_ALL = "SELECT `id`, `imageAddress` FROM `image`";
    @Override
    public List<Image> readAll() throws SQLException, ConstantException, ClassNotFoundException {
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
    public void delete(Integer id) throws ConstantException, ClassNotFoundException {

    }

    @Override
    public void create(Image entity) throws ConstantException, ClassNotFoundException {

    }

    @Override
    public Image update(Image entity) throws ConstantException, ClassNotFoundException {
        return null;
    }
}
