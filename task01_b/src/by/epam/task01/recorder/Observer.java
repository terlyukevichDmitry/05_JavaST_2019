package by.epam.task01.recorder;

import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.PyramidException;

/**
 *An public interface for creating Observer Method.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public interface Observer {
    /**
     * @param pyramid object.
     * @throws PyramidException for check exception.
     */
    void update(Pyramid pyramid) throws PyramidException;
}
