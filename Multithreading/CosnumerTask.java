package Tree.Multithreading;

public class CosnumerTask implements Runnable {
    SharedResource sharedResource;

    public CosnumerTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }


    @Override
    public void run() {
        System.out.println("Consumer Task");
        sharedResource.consumeItem();
    }
}
