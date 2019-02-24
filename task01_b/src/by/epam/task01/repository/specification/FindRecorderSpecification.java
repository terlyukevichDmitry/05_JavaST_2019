package by.epam.task01.repository.specification;

import by.epam.task01.recorder.Recorder;

@SuppressWarnings("CheckStyle")
public interface FindRecorderSpecification extends PyramidSpecification {
    boolean specified(Recorder recorder);
}
