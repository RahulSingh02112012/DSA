package Tree.Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResourceQueue {
    private Queue<Integer> queue;
    private int bufferSize;

    public SharedResourceQueue(int bufferSize) {
        this.queue = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void addItem(int item) throws InterruptedException {
        //Check if queue is full wait
        while (queue.size() == this.bufferSize) {
            System.out.println("Buffer is full waiting to add item");
            wait();
        }
        queue.add(item);
        System.out.println("Item Added to buffer");
        notifyAll();
    }

    public synchronized int consumeItem() throws InterruptedException {
        while(queue.isEmpty()) {
            System.out.println("Buffer is empty waiting for an item");
            wait();
        }
        int removedItem = queue.remove();
        System.out.println("Item consumed");
        notifyAll();
        return removedItem;
    }
}
