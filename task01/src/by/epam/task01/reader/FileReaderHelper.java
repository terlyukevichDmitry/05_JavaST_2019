/**
 * Domain classes used to produce .....
 * <p>
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevich
 * @version 1.0
 */

package by.epam.task01.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
public class FileReaderHelper {

    /**
     * It's a first constructor in this class.
     */
    public FileReaderHelper() {
    }

    /**
     * This readArrayOfString we use for read information of file.
     * @return string with component for solutions this task.
     */
    public List<String> readArrayOfString() {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get("data" + File.separator + "file.txt");
        try (Stream<String> lineStream = Files.lines(path)) {

            lines = lineStream.collect(Collectors.toList());

        } catch (IOException ignored) {
        }
        return lines;
    }


}
