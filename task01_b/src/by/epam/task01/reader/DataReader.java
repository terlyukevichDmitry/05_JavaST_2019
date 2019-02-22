
/**
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevich
 * @version 1.0
 */
package by.epam.task01.reader;

import by.epam.task01.exception.FileEmptyException;
import by.epam.task01.exception.MissingWayFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.UncheckedIOException;
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
    public List<String> readListOfString(final String file)
            throws MissingWayFileException {
        List<String> list = new ArrayList<>();

        if (file != null) {
            try (Stream<String> stream = Files.lines(Paths.get(file))) {
                list = stream.map(String::toLowerCase).collect(
                        Collectors.toList());
                if (list.isEmpty()) {
                    throw new FileEmptyException("We have empty file.");
                }
            } catch (IOException ex) {
                LOGGER.warn("We have problem with this method. Please,"
                        + " correct this mistake.", ex);
            } catch (FileEmptyException ex) {
                LOGGER.warn("File is empty", ex);
            } catch (UncheckedIOException ex) {
                LOGGER.warn("False file path is a directory", ex);
            }
            return list;
        } else {
            LOGGER.error("We don't have text in file");
            throw new MissingWayFileException(
                    "We don't have text in file");
        }
    }
}
