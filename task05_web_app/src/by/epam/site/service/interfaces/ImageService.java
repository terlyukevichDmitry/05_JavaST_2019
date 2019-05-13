package by.epam.site.service.interfaces;

import by.epam.site.entity.Image;
import by.epam.site.exception.ConstantException;

import java.sql.SQLException;
import java.util.List;

public interface ImageService extends Service {
    List<Image> findAll() throws ConstantException,
            SQLException, ClassNotFoundException;
    void save(Image image)
            throws ConstantException, ClassNotFoundException, SQLException;
    void delete(Integer id) throws ClassNotFoundException, ConstantException;
    void read(final Image image)
            throws ConstantException;
    void create(Image image) throws ConstantException, SQLException, ClassNotFoundException;
}
