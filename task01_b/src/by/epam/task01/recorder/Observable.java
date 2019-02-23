package by.epam.task01.recorder;

import by.epam.task01.exception.PyramidException;

/**
 *An public interface for creating Observer Method.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public interface Observable {
    /**
     * For add new observer.
     * @param observer object.
     */
    void addObserver(Observer observer);
    /**
     * For removeObserver observer.
     * @param observer object.
     */
    void removeObserver(Observer observer);
    /**
     * For notify all Observers.
     * @throws PyramidException for check exception.
     */
    void notifyObservers() throws PyramidException;
}
