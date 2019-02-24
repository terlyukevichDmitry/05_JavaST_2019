package by.epam.task01.repository.specification;

import by.epam.task01.entity.Pyramid;
import by.epam.task01.recorder.Recorder;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByVolumeSpecification implements SortRecorderSpecification {
    @Override
    public List<Recorder> sort(final List<Recorder> recorders) {
        Collections.sort(recorders,
                Comparator.comparing(Recorder::getVolume));
        return recorders;
    }
}
