package by.epam.task01.factory;

import by.epam.task01.entity.Point;

@SuppressWarnings("CheckStyle")
public interface PointFactory extends Factory<PointFactory> {
    Point createPoint(final double coordinateX,
                      final double coordinateY,
                      final double coordinateZ);
}
