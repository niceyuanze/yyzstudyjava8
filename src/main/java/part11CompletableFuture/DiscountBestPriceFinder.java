package part11CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by niceyuanze on 17-4-21.
 */
public class DiscountBestPriceFinder {

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
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());


//        return shops.stream()
//                .map( shop -> String.format("%s price is %.2f",
//                        shop.getName(),shop.getPrice(product)))
//                .collect(Collectors.toList());
    }

    public List<String> findPricesParallelStream(String product){
        return shops.parallelStream()
                .map( shop -> String.format("%s price is %.2f",
                        shop.getName(),shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesByCompletableFuture(String product){
        List<CompletableFuture<String>> priceFuture =
                shops.stream()
                .map(shop -> CompletableFuture.supplyAsync( () -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote),executor
                )))
                .collect(Collectors.toList());
        return priceFuture.stream().map(CompletableFuture::join)
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

    public Stream<CompletableFuture<String>> findPricesStream(String product){
        return shops.stream()
                .map( shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice(product), executor
                ))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose( quote -> CompletableFuture
                        .supplyAsync( () -> Discount.applyDiscount(quote), executor)));
    }




}
