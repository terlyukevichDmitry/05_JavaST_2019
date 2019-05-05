package by.epam.site.service.interfaces;

import by.epam.site.entity.QuestPlace;
import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;

import java.sql.SQLException;
import java.util.List;

public interface ReviewService extends Service {
    List<Review> findAll() throws ConstantException,
            SQLException, ClassNotFoundException;
    void save(Review entity) throws ConstantException, ClassNotFoundException;
    void delete(Integer id) throws ClassNotFoundException, ConstantException;
}
