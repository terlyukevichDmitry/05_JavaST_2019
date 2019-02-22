package by.epam.task01.recorder;

import by.epam.task01.exception.PyramidException;

@SuppressWarnings("CheckStyle")
public interface Observable {

    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers() throws PyramidException;

}
