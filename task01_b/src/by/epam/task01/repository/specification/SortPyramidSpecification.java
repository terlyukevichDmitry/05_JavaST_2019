package by.epam.task01.repository.specification;

import by.epam.task01.entity.Pyramid;

import java.util.List;
@SuppressWarnings("CheckStyle")
public interface SortPyramidSpecification extends PyramidSpecification {
    List<Pyramid> sort(List<Pyramid> pyramidList);
}
