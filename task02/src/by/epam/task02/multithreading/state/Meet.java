package by.epam.task02.multithreading.state;

public class Meet implements StateTaxi {
    @Override
    public void motion() {
        System.out.println("I'm going to meeting with customer!");
    }
}
