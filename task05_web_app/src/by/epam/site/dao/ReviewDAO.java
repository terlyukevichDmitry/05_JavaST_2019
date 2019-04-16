package by.epam.site.dao;

import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;

public interface ReviewDAO {
    void initializeClient(Review review)
            throws ConstantException, ClassNotFoundException;
}
