package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daointerfaces.ReviewDAO;
import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ReviewService;

import java.sql.SQLException;
import java.util.List;

public class ReviewServiceImpl extends ServiceImpl implements ReviewService {
    @Override
    public List<Review> findAll() throws ConstantException, SQLException, ClassNotFoundException {
        ReviewDAO dao = transaction.createDaoImpl(ReviewDAO.class);
        return dao.readAll();
    }

    @Override
    public void save(Review review) throws ConstantException, ClassNotFoundException, SQLException {
        ReviewDAO dao = transaction.createDaoImpl(ReviewDAO.class);
        if(review.getId() != null) {
            dao.update(review, transaction);
        } else {
            review.setId(dao.create(review, transaction));
        }
    }

    @Override
    public void delete(Integer id) throws ClassNotFoundException, ConstantException {
        ReviewDAO dao = transaction.createDaoImpl(ReviewDAO.class);
        dao.delete(id);
    }
}
