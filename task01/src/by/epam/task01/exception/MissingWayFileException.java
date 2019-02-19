
/**
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevich
 * @version 1.0
 */
package by.epam.task01.exception;

/**
 *An public class for reading different information.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class MissingWayFileException extends Exception {
    /**
     * It's a main constructor in this class.
     * @param information for show info
     */
    public MissingWayFileException(final String information) {
        super(information);
    }
}
