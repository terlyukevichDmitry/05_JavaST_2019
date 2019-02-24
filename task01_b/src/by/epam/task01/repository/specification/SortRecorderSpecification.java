package by.epam.task01.repository.specification;

import by.epam.task01.entity.Pyramid;
import by.epam.task01.recorder.Recorder;

import java.util.List;

public interface SortRecorderSpecification extends PyramidSpecification {
    List<Recorder> sort(List<Recorder> recorders);
}
