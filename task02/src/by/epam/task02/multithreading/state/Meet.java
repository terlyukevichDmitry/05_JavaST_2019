package by.epam.task02.multithreading.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *An public class for state pattern realization.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class Meet implements StateTaxi {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(Meet.class);

    /**
     * {@inheritDoc}
     * show information taxi motion with person.
     */
    @Override
    public void motion() {
        LOGGER.info("I'm going to meeting with customer!");
    }
}
