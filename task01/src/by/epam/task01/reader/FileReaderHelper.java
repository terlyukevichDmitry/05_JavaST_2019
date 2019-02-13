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

/**
 *An public class for reading different information.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class FileReaderHelper {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER = LogManager.getLogger(
            FileReaderHelper.class);

    /**
     * It's a first constructor in this class.
     */
    public FileReaderHelper() {
    }

    /**
     * This readArrayOfString we use for read information of file.
     * @return string with component for solutions this task.
     */
    public String readArrayOfString() {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get("data"
                    + File.separator + "file.txt")));
        } catch (IOException e) {
            LOGGER.warn("We have problem with this method. Please,"
                    + " correct this mistake.", e);
        }
        return content;
    }
}
