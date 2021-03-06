package part11CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * Created by niceyuanze on 17-4-21.
 */
public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"), new Shop("ShopEasy"));


    private final Executor executor =
            Executors.newFixedThreadPool(Math.min(shops.size(), 100),

                    new ThreadFactory() {

                        @Override
                        public Thread newThread(Runnable r) {
                            Thread t = new Thread(r);
                            t.setDaemon(true);
                            return t;
                        };

                    });


    public List<String> findPricesSequential(String product){
        return shops.stream()
                .map( shop -> String.format("%s price is %.2f",
                        shop.getName(),shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesParallelStream(String product){
        return shops.parallelStream()
                .map( shop -> String.format("%s price is %.2f",
                        shop.getName(),shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesByCompletableFuture(String product){
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                .map( shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + "price is " + shop.getPrice(product)
                ))
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public List<String> findPricesByCompletableFutureUseExecutor(String product){
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map( shop -> CompletableFuture.supplyAsync(
                                () -> shop.getName() + "price is " + shop.getPrice(product), executor
                        ))
                        .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }




}
