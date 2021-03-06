package part11CompletableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by niceyuanze on 17-4-21.
 */
public class ShopMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Shop shop = new Shop("BstShop");
        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync1("my favorite product");

        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");


        doSomethingElse();

        double price = futurePrice.get();
        System.out.printf("Price is %.2f%n", price);

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
    private static void doSomethingElse() {
        System.out.println("Doing something else...");
    }

}
