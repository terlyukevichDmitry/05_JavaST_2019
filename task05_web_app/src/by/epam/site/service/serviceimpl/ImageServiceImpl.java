package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daointerfaces.ImageDAO;
import by.epam.site.dao.daointerfaces.QuestDAO;
import by.epam.site.entity.Image;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ImageService;

import java.sql.SQLException;
import java.util.List;

public class ImageServiceImpl extends ServiceImpl implements ImageService {
    @Override
    public List<Image> findAll() throws ConstantException, SQLException, ClassNotFoundException {
        ImageDAO dao = transaction.createDaoImpl(ImageDAO.class);
        return dao.readAll();
    }

    @Override
    public void save(Image image) throws ConstantException, ClassNotFoundException, SQLException {
        ImageDAO dao = transaction.createDaoImpl(ImageDAO.class);
        if(image.getId() != null) {
            dao.update(image, transaction);
        } else {
            image.setId(dao.create(image, transaction));
        }
    }

    @Override
    public void delete(Integer id) throws ClassNotFoundException, ConstantException {
        ImageDAO dao = transaction.createDaoImpl(ImageDAO.class);
        dao.delete(id);
    }

    @Override
    public void read(Image image) throws ConstantException {
        ImageDAO dao = transaction.createDaoImpl(ImageDAO.class);
        dao.read(image);
    }
}
