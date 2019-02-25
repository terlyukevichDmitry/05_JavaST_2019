package by.epam.task01.repository.specification;

import by.epam.task01.recorder.Recorder;

import java.util.List;

/**
 * In this interface we use for sorting data.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public interface SortRecorderSpecification extends PyramidSpecification {
    /**
     * Sorting data in different moments.
     * @param recorders list with pyramid objects.
     * @return List<Recorder>.
     */
    List<Recorder> sort(List<Recorder> recorders);
}
