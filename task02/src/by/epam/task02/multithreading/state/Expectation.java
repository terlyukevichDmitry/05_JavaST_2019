package by.epam.task02.multithreading.state;

public class Expectation implements StateTaxi {
    @Override
    public void motion() {
        System.out.println("I'm expectation bell from customers!");
    }
}
