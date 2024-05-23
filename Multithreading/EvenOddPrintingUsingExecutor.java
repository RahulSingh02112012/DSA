package Tree.Multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenOddPrintingUsingExecutor {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.range(1,10).forEach(num-> {
            CompletableFuture<Integer> oddCompleteablefut = CompletableFuture.completedFuture(num)
                    .thenApplyAsync(x->{
                        if(x%2 != 0) {
                            System.out.println("Thread name: " + Thread.currentThread().getName() + ": "+ x);
                        }
                        return num;
                    },executorService);
            oddCompleteablefut.join();
            CompletableFuture<Integer> evenCompleteablefut = CompletableFuture.completedFuture(num)
                    .thenApplyAsync(x->{
                        if(x%2 == 0) {
                            System.out.println("Thread name: " + Thread.currentThread().getName() + ": "+ x);
                        }
                        return num;
                    },executorService);
            evenCompleteablefut.join();
                }

        );
    }
}
