
/**
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevich
 * @version 1.0
 */
package by.epam.task01.reader;

import by.epam.task01.exception.FileEmptyExeption;
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
 *An public class for reading different information.
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

        if (file == null) {
                throw new MissingWayFileException(
                        "We don't have text in file");
        }

        try (Stream<String> stream = Files.lines(Paths.get(file))) {
            list = stream.map(String::toLowerCase).collect(Collectors.toList());
            if (list.isEmpty()) {
                throw new FileEmptyExeption("We have empty file.");
            }
        } catch (IOException ex) {
            LOGGER.warn("We have problem with this method. Please,"
                           + " correct this mistake.", ex);
        } catch (FileEmptyExeption ex) {
            LOGGER.warn("File is empty", ex);
        } catch (UncheckedIOException ex) {
            LOGGER.warn("Incorrect input", ex);
        }
        return list;
    }
}
