package fifth;

import java.util.concurrent.Semaphore;

public class PhilosophersApp {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);
        for (int i = 1; i < 6; i++)
        new Philosopher(sem, i).start();
    }
}
