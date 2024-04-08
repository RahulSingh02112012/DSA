package Tree.Multithreading;

public class SharedResource {

    boolean isItemAvailable;

    public synchronized void addItem() {
        isItemAvailable = true;
        System.out.println("Added item");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("Consume Item invoked by" + Thread.currentThread().getName());

        while(!isItemAvailable) {
            System.out.println("Waiting for item");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Item consumer");
        isItemAvailable = false;
    }
}
