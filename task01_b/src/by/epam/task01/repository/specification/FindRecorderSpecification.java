package by.epam.task01.repository.specification;

import by.epam.task01.recorder.Recorder;

/**
 * In this interface we use for finding data.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public interface FindRecorderSpecification extends PyramidSpecification {
    /**
     * Public boolean method for finding correct data.
     * @param recorder object.
     * @return true or false.
     */
    boolean specified(Recorder recorder);
}
