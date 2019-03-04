package by.epam.task02.multithreading.state;

public class Trip implements StateTaxi {
    @Override
    public void motion() {
        System.out.println("We are moving to person house!");
    }
}
