package part11CompletableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by niceyuanze on 17-4-21.
 */
public class BestPriceFinderMain {
    public static void main(String[] args) {
        DiscountBestPriceFinder discountBestPriceFinder = new DiscountBestPriceFinder();
//        long start = System.nanoTime();
//        System.out.println(discountBestPriceFinder.findPricesByCompletableFuture("myPhone23S"));
//
//        long duration = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Done in " + duration + " msecs");
//        CompletableFuture[] futures = discountBestPriceFinder.findPricesStream("myPhone")
//                .map( f -> f.thenAccept(System.out::println))
//                .toArray( size -> new CompletableFuture[size]);
//        CompletableFuture.allOf(futures).join();

        long start = System.nanoTime();
        CompletableFuture[] futures = discountBestPriceFinder.findPricesStream("myPhone27s")
                .map( f -> f.thenAccept(
                        s -> System.out.println(s + " (done in " + ((System.nanoTime() - start) / 1_000_000) + " msecs")
                ))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
        System.out.println("All shops have now responded in" + ((System.nanoTime() - start) / 1_000_000) +"msecs");

    }

//    public void test(){
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        final Future(Double) futureRate = executorService.submit(new Callable<Double>() {
//
//            @Override
//            public Double call() throws Exception {
//                return
//            }
//        })
//    }
}
