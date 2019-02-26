package by.epam.task01.repository.specification;

import by.epam.task01.entity.Pyramid;

import java.util.Comparator;

/**
 * In this class we use for sorting data.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class SortBySecondPointXSpecification implements SortPointSpecification {
    /**
     * {@inheritDoc}
     */
    @Override
    public Comparator<Pyramid> sortSpecification() {
        return Comparator.comparingDouble(
                value -> value.getPointList(1).getX());
    }
}
