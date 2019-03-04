package by.epam.task02.multithreading.home;

public class Home {
    private double x;
    private double y;

    public Home(double x, double y) {
        this.x = x;
        this.y = y;
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

    @Override
    public String toString() {
        return "Home{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
