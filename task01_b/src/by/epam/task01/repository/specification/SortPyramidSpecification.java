package by.epam.task01.repository.specification;

import by.epam.task01.entity.Pyramid;

import java.util.List;
/**
 * In this interface we use for sorting data.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public interface SortPyramidSpecification extends PyramidSpecification {
    /**
     * Sorting data in different moments.
     * @param pyramidList list with pyramid objects.
     * @return List<Pyramid>.
     */
    List<Pyramid> sort(List<Pyramid> pyramidList);
}
