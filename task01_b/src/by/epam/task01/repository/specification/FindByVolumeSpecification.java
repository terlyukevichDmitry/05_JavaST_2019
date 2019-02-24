package by.epam.task01.repository.specification;

import by.epam.task01.recorder.Recorder;

@SuppressWarnings("CheckStyle")
public class FindByVolumeSpecification implements FindRecorderSpecification {
    private double lowerBorder;
    private double upperBorder;

    public FindByVolumeSpecification(double lowerBorder, double upperBorder) {
        this.lowerBorder = lowerBorder;
        this.upperBorder = upperBorder;
    }

    @Override
    public boolean specified(Recorder recorder) {
        return recorder.getVolume() >= lowerBorder
                && recorder.getVolume() <= upperBorder;
    }
}
