package Tree.Multithreading;

public class MainClass {
    public static void main(String[] args) {
        MultiThreadedClass runnableObj = new MultiThreadedClass();
        Thread thread = new Thread(runnableObj);
       // thread.start();


        // Monitor Lock Example

        MonitorLockExample obj = new MonitorLockExample();

       /* new Thread(()->{
            obj.task1();
        }).start();

        new Thread(()->{
            obj.task2();
        }).start();

        new Thread(()->{
            obj.task3();
        }).start();*/

        // Consumer - producer basic
        SharedResource sharedResource = new SharedResource();

        Thread prodThread = new Thread(new ProducerTask(sharedResource));
        Thread consumerThread = new Thread(new CosnumerTask(sharedResource));

      //  prodThread.start();
      //  consumerThread.start();

        SharedResourceQueue sharedResourceQueue = new SharedResourceQueue(3);

        Thread queueProdThread = new Thread(() -> {
            for(int i = 0 ;i<=6 ;i++) {
                try {
                    sharedResourceQueue.addItem(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread queueConsumerThread = new Thread(() -> {
            for(int i = 0 ;i<=6 ;i++) {
                try {
                    sharedResourceQueue.consumeItem();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        queueProdThread.start();
        queueConsumerThread.start();
    }
}
