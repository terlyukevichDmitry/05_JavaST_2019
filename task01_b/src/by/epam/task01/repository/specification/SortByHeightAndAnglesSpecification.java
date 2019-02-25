package by.epam.task01.repository.specification;

import by.epam.task01.entity.Pyramid;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * In this class we use for sorting data.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class SortByHeightAndAnglesSpecification
        implements SortPyramidSpecification {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pyramid> sort(final List<Pyramid> pyramidList) {
        Collections.sort(pyramidList,
                Comparator.comparing(Pyramid::getNumberOfAngles)
                        .thenComparing(Pyramid::getHeight));
        return pyramidList;
    }
}
