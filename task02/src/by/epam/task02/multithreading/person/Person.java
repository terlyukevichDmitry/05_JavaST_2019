package by.epam.task02.multithreading.person;

import by.epam.task02.multithreading.action.Calculator;
import by.epam.task02.multithreading.entity.Taxi;
import by.epam.task02.multithreading.singleton.Uber;
import by.epam.task02.multithreading.entity.Home;
import by.epam.task02.multithreading.state.Expectation;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Person implements Callable<Person> {

    private double x;
    private double y;
    private double radius;
    private Home home;
    private Calculator calculator;

    public Person(double x, double y, double radius, Home home) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.home = home;
        calculator = new Calculator();
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
    public Person call() {
        System.out.println(this + ": READY!!!!");

        Taxi taxi = Uber.INSTANCE.getTaxi(this);
        long time = calculator.calculateTime(taxi, this);
        taxi.setCheckTaxi(true);

        System.out.println(taxi + " : I can meet you! number taxi = "
                + taxi.getTaxiNumber() + " = " + this);
        taxi.setStateTaxi(new Expectation());
        System.out.println("taxi = " + taxi);
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                System.out.println(this + " : delivered!");
                taxi.setY(home.getY());
                taxi.setX(home.getX());
                taxi.setCheckTaxi(false);
            }
            taxi.nextStation();
            taxi.motion();
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

}
