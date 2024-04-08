package Tree.Multithreading;

public class MonitorLockExample {

    public synchronized void task1() {
        try {
            System.out.println("Inside task1");
            Thread.sleep(10000);
            System.out.println("Task1 Completed");
        } catch (Exception ex) {
            //
        }
    }

    public void task2() {
        System.out.println("Before Sync task 2");

        synchronized (this) {
            System.out.println("After Synce task 2");
        }
    }

    public void task3() {
        System.out.println("task 3");
    }
}
