package by.epam.task01.repository.specification;

import by.epam.task01.recorder.Recorder;

@SuppressWarnings("CheckStyle")
public class FindBySquareSpecification implements FindRecorderSpecification {
    private double lowerBorder;
    private double upperBorder;

    public FindBySquareSpecification(double lowerBorder, double upperBorder) {
        this.lowerBorder = lowerBorder;
        this.upperBorder = upperBorder;
    }

    @Override
    public boolean specified(Recorder recorder) {
        return recorder.getSquare() >= lowerBorder
                && recorder.getSquare() <= upperBorder;
    }
}
