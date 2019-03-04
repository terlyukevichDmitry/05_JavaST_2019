package first;

/**
 * klsdklasdfklajsodi fskdfadfkjasdkfaksdfkasd flkajsdlfk/.
 */
public class ProducerConsumerApp {
    /**
     * Constructor.
     */
    public ProducerConsumerApp() {
    }

    /**
     * main method.
     * @param args yep.
     */
    public static void main(final String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        producer.start();
        consumer.start();

    }
}
