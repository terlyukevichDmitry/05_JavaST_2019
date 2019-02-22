package by.epam.task01.recorder;

import by.epam.task01.exception.PyramidException;

@SuppressWarnings("CheckStyle")
public interface Observer {
    public void update(Object object) throws PyramidException;
}
