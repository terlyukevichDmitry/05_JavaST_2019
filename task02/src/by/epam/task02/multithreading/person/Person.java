package by.epam.task02.multithreading.person;

import by.epam.task02.multithreading.action.Calculator;
import by.epam.task02.multithreading.entity.Taxi;
import by.epam.task02.multithreading.singleton.Uber;
import by.epam.task02.multithreading.entity.Home;
import by.epam.task02.multithreading.state.Expectation;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Person implements Callable<Person> {

    private double x;
    private double y;
    private double radius;
    private ReentrantLock locker;
    private Home home;

    public Person(double x, double y, double radius, Home home,
                  ReentrantLock locker) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.home = home;
        this.locker = locker;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Person{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", home=" + home +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.x, x) == 0 &&
                Double.compare(person.y, y) == 0 &&
                Double.compare(person.radius, radius) == 0 &&
                Objects.equals(home, person.home);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, radius, home);
    }

    @Override
    public Person call() throws Exception {
        List<Taxi> list = Uber.INSTANCE.getTaxiList();
        Calculator calculator = new Calculator();
        locker.lock();
        for (Taxi taxi : list) {
            if (calculator.checkPosition(taxi, radius)) {
                if (calculator.calculateSide(taxi, this)
                        == calculator.checkComparison(list, this)) {
                    System.out.println(taxi.getName() +
                            " : I can meet you! number taxi = "
                            + taxi.getTaxiNumber());
                    taxi.setStateTaxi(new Expectation());
                    for (int i = 0; i < 3; i++) {
                        if(i == 2) {
                            System.out.println(this + " : delivered!");
                        }
                        taxi.nextStation();
                        taxi.motion();
                        TimeUnit.MILLISECONDS.sleep(500);
                    }
                    taxi.setX(home.getX());
                    taxi.setY(home.getY());
                    locker.unlock();
                    return this;
                } else {
                    System.out.println(taxi.getName() + " : I think other taxi driver can meet you!");
                }
            } else {
                System.out.println(taxi.getName() + " : I can't meet you! Plz, die.");
                TimeUnit.MILLISECONDS.sleep(500);
            }
        }
        locker.unlock();
        return this;
    }
}
