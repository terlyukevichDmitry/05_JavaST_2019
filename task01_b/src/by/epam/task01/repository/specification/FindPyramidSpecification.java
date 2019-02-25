package by.epam.task01.repository.specification;

import by.epam.task01.entity.Pyramid;

/**
 * In this interface we use for finding data.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public interface FindPyramidSpecification extends PyramidSpecification {
    /**
     * Public boolean method for finding correct data.
     * @param pyramid object.
     * @param index for finding true objects.
     * @return true or false.
     */
    boolean specified(Pyramid pyramid, int index);
}
