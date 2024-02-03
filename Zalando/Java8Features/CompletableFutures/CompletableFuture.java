package Tree.Zalando.Java8Features.CompletableFutures;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Asyn promgramming where tasks are executed in different threads
// How can we achieve asyn programming in java
// Future/ Executor Service/ Callbale / Thread pool
/*
With Futures following cant be achieved:

 */
public class CompletableFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<List<Integer>> future = executorService.submit(() -> {
            return Arrays.asList(1,2,3,4,5);
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
