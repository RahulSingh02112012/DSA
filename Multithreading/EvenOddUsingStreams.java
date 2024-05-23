package Tree.Multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddUsingStreams {
    private static Object object = new Object();
    private static IntPredicate evenCond = e -> e % 2 == 0;
    private static IntPredicate oddCond = e -> e % 2 != 0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()-> EvenOddUsingStreams.printResult(oddCond));
        CompletableFuture.runAsync(()-> EvenOddUsingStreams.printResult(evenCond));

        Thread.sleep(1000);
    }

    public static void printResult(IntPredicate cond) {
        IntStream.rangeClosed(1,10).filter(cond).forEach(EvenOddUsingStreams::execute);
    }

    private static void execute(int i) {
        synchronized (object) {
            try {
            System.out.println("Thread name: " + Thread.currentThread().getName() + ": "+ i);
            object.notify();
            object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
