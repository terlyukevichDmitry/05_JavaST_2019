package by.epam.task01.repository.specification;

import by.epam.task01.entity.Pyramid;
@SuppressWarnings("CheckStyle")
public class FindByHeightSpecification implements FindPyramidSpecification {
    private double lowerBorder;
    private double upperBorder;

    public FindByHeightSpecification(final double lowerBorder,
                                 final double upperBorder) {
        this.lowerBorder = lowerBorder;
        this.upperBorder = upperBorder;
    }

    @Override
    public boolean specified(Pyramid pyramid, int index) {
        return pyramid.getHeight() >= lowerBorder
                && pyramid.getHeight() <= upperBorder;
    }
}
