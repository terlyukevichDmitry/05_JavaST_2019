package by.epam.task01.factory;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;

import java.util.List;
@SuppressWarnings("CheckStyle")
public interface PyramidFactory extends Factory<PyramidFactory> {
    Pyramid createPyramid(final List<Point> pointList,
                                 final double angles,
                                 final double height);

}
