package by.epam.site.dao.interfaces;

import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;

public interface ReviewDAO extends DaoPattern<Review> {
    void initializeClient(Review review)
            throws ConstantException, ClassNotFoundException;
}
