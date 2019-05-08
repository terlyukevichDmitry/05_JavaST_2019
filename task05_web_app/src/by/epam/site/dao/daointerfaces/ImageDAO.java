package by.epam.site.dao.daointerfaces;

import by.epam.site.entity.Image;
import by.epam.site.exception.ConstantException;

public interface ImageDAO extends DaoPattern<Image> {
    void read(final Image image)
            throws ConstantException;
}
