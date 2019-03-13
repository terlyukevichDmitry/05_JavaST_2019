package by.epam.informationhandling.creator;

import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.reader.DataReader;

public class StringCreator {

    public String creatingString(final String file)
            throws MissingWayFileException {
        DataReader dataReader = new DataReader();
        String string = dataReader.readListOfString(file);
        return string;
    }
}
