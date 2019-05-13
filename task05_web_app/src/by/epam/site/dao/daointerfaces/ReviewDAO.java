package by.epam.site.dao.daointerfaces;

import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;

public interface ReviewDAO extends DaoPattern<Review> {
    void deleteByClientId(Integer clientId) throws ConstantException;
}
