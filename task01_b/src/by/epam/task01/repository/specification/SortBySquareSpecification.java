package by.epam.task01.repository.specification;

import by.epam.task01.recorder.Recorder;

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
public class SortBySquareSpecification implements SortRecorderSpecification {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Recorder> sort(final List<Recorder> recorders) {
        Collections.sort(recorders,
                Comparator.comparing(Recorder::getSquare));
        return recorders;
    }
}
