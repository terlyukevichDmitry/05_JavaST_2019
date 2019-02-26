package by.epam.task01.repository.specification;

import by.epam.task01.entity.Pyramid;

import java.util.Comparator;

/**
 * This interface we use for sorting data for point parameters.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public interface SortPointSpecification extends PyramidSpecification {
    /**
     * For sorting data.
     * @return comparator.
     */
    Comparator<Pyramid> sortSpecification();
}
