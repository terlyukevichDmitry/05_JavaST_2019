package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.dao.daointerfaces.ReviewDAO;
import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.service.interfaces.ReviewService;
import by.epam.site.service.interfaces.ServiceFactory;

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
        review.setId(dao.create(review, transaction));
    }

    @Override
    public void delete(Integer id) throws ClassNotFoundException, ConstantException {
        ReviewDAO dao = transaction.createDaoImpl(ReviewDAO.class);
        dao.delete(id);
    }

    @Override
    public void initDate(List<Review> reviews) throws ConstantException {
        ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        ClientService service = factory.getService(ClientService.class);
        for (Review review :reviews) {
            review.setClient(service.findById(review.getClient().getId()));
            if (("nope").equals(review.getClient().getFilePath())) {
                review.getClient().setFilePath("/images/noPerson.jpg");
            }
        }
        factory.close();
    }

    @Override
    public void deleteByClientId(Integer clientId) throws ConstantException {
        ReviewDAO dao = transaction.createDaoImpl(ReviewDAO.class);
        dao.deleteByClientId(clientId);
    }
}
