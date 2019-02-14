
/**
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevich
 * @version 1.0
 */

package by.epam.task01.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
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
    private static final Logger LOGGER = LogManager.getLogger(
            DataReader.class);

    /**
     * It's a first constructor in this class.
     */
    public DataReader() {

    }

    /**
     * This readArrayOfString we use for read information of file.
     * @return string with component for solutions this task.
     */
    public List<String> readArrayOfString() {
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get("data"
                      + File.separator + "file.txt"))) {

            list = stream
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            LOGGER.warn("We have problem with this method. Please,"
                           + " correct this mistake.", e);
        }

        return list;
    }
}
