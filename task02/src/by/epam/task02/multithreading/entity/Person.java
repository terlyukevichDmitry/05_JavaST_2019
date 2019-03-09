package by.epam.task02.multithreading.entity;

import by.epam.task02.multithreading.action.Calculator;
import by.epam.task02.multithreading.exception.PersonDataException;
import by.epam.task02.multithreading.singleton.Uber;
import by.epam.task02.multithreading.state.Expectation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *An public Home entity class.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class Person implements Callable<Person> {

    /**
     * x coordinate.
     */
    private double x;
    /**
     * y coordinate.
     */
    private double y;
    /**
     * radius for taxi application.
     */
    private double radius;
    /**
     * home person.
     */
    private Home home;
    /**
     * object for calculator methods.
     */
    private Calculator calculator;
    /**
     * constant.
     */
    private final int three = 3;
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER = LogManager.getLogger(Person.class);

    /**
     * constructor for init data.
     * @param coordinateX for x.
     * @param coordinateY for y.
     * @param radiusT for radius.
     * @param homeT for home.
     * @throws PersonDataException for check data.
     */
    public Person(final double coordinateX, final double coordinateY,
                  final double radiusT, final Home homeT)
            throws PersonDataException {
        this.x = coordinateX;
        this.y = coordinateY;
        this.radius = radiusT;
        if (homeT == null) {
            LOGGER.warn("We have uncorrect home data");
            throw new PersonDataException("We have uncorrect home data");
        }
        this.home = homeT;
        calculator = new Calculator();
    }

    /**
     * get home person.
     * @return home coordinate.
     */
    public Home getHome() {
        return home;
    }

    /**
     * set home coordinate.
     * @param homeT for home.
     * @throws PersonDataException for check data.
     */
    public void setHome(final Home homeT) throws PersonDataException {
        if (homeT == null) {
            LOGGER.warn("We have uncorrect home data");
            throw new PersonDataException("We have uncorrect home data");
        }
        this.home = homeT;
    }

    /**
     * get x coordinate.
     * @return x.
     */
    public double getX() {
        return x;
    }

    /**
     * set x coordinate.
     * @param coordinateX for x.
     */
    public void setX(final double coordinateX) {
        this.x = coordinateX;
    }

    /**
     * get y coordinate.
     * @return y.
     */
    public double getY() {
        return y;
    }

    /**
     * set y coordinate.
     * @param coordinateY for y.
     */
    public void setY(final double coordinateY) {
        this.y = coordinateY;
    }

    /**
     * get radius.
     * @return radius.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * set radius data.
     * @param radiusT for radius.
     */
    public void setRadius(final double radiusT) {
        this.radius = radiusT;
    }
    /**
     * {@inheritDoc}
     *
     * @return string with this information.
     */
    @Override
    public String toString() {
        return "Person{" + "x=" + x + ", y=" + y + ", radius=" + radius
                + ", home=" + home + '}';
    }
    /**
     * {@inheritDoc}
     *
     * @return equals result.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Double.compare(person.x, x) == 0
                && Double.compare(person.y, y) == 0
                && Double.compare(person.radius, radius) == 0
                && Objects.equals(home, person.home);
    }
    /**
     * {@inheritDoc}
     *
     * @return hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, radius, home);
    }
    /**
     * {@inheritDoc}
     *
     * @return Person after thread worked.
     */
    @Override
    public Person call() {
        LOGGER.info(this + ": READY!!!!");

        Taxi taxi = Uber.INSTANCE.getTaxi(this);
        long time = calculator.calculateTime(taxi, this);
        LOGGER.info(taxi + " : I can meet you! number taxi = "
                + taxi.getTaxiNumber() + " = " + this);
        taxi.setStateTaxi(new Expectation());
        LOGGER.info("taxi = " + taxi);
        for (int i = 0; i < three; i++) {
            if (i == 2) {
                LOGGER.info(this + " : delivered!");
                taxi.setY(home.getY());
                taxi.setX(home.getX());
                taxi.setCheckTaxi(false);
            }
            taxi.nextStation();
            taxi.motion();
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                LOGGER.warn("we have mistake: ", e);
            }
        }
        return this;
    }

}
