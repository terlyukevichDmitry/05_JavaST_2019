package by.epam.task01.repository.specification;

import by.epam.task01.entity.Pyramid;

@SuppressWarnings("CheckStyle")
public interface FindPyramidSpecification extends PyramidSpecification {
    boolean specified(Pyramid pyramid, int index);
}
