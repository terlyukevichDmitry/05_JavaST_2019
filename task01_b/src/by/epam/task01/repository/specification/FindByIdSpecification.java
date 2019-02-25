package by.epam.task01.repository.specification;

import by.epam.task01.entity.Pyramid;

/**
 * In this class we use for finding data.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class FindByIdSpecification implements FindPyramidSpecification {
    /**
     * Lower border for finding true object.
     */
    private double lowerBorder;
    /**
     * Lower border for finding true object.
     */
    private double upperBorder;
    /**
     * Constructor for initialization data.
     * @param lowerBorderP for finding true data.
     * @param upperBorderP for finding true data.
     */
    public FindByIdSpecification(final double lowerBorderP,
                                          final double upperBorderP) {
        this.lowerBorder = lowerBorderP;
        this.upperBorder = upperBorderP;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean specified(final Pyramid pyramid, final int index) {
        return pyramid.getId() >= lowerBorder
                && pyramid.getId() <= upperBorder;
    }
}
