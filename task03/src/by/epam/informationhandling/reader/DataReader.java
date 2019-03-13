package by.epam.informationhandling.reader;

import by.epam.informationhandling.exception.FileEmptyException;
import by.epam.informationhandling.exception.MissingWayFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * In this class we use for reading data of different files.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class DataReader {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);
    /**
     * This readListOfString we use for read information of file.
     * @param file for.
     * @throws MissingWayFileException problem.
     * @return string with component for solutions this task.
     */
    public String readListOfString(final String file)
            throws MissingWayFileException {
        String string = "";

        if (file != null) {
            try {
                string = Files.readString(Paths.get(file));
            } catch (IOException ex) {
                LOGGER.warn("We have problem with this method. Please,"
                        + " correct this mistake.", ex);
            } catch (UncheckedIOException ex) {
                LOGGER.warn("False file path is a directory", ex);
            }
            return string;
        } else {
            LOGGER.error("We don't have text in file");
            throw new MissingWayFileException(
                    "We don't have text in file");
        }
    }
}
