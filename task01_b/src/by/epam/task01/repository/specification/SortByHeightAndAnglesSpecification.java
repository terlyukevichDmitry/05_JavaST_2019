package by.epam.task01.repository.specification;

import by.epam.task01.entity.Pyramid;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@SuppressWarnings("CheckStyle")
public class SortByHeightAndAnglesSpecification
        implements SortPyramidSpecification {

    @Override
    public List<Pyramid> sort(List<Pyramid> pyramidList) {
        Collections.sort(pyramidList,
                Comparator.comparing(Pyramid::getNumberOfAngles)
                        .thenComparing(Pyramid::getHeight));
        return pyramidList;
    }
}
