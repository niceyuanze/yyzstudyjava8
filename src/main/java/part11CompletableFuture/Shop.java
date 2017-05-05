package part11CompletableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by niceyuanze on 17-4-21.
 */
public class Shop {



    private final String name;
    private final Random random;

    public String getName() {
        return name;
    }

    public Random getRandom() {
        return random;
    }

    public Shop(String name){
        this.name = name;
        random  = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getPrice(String product){
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public  Future<Double> getPriceAsync(String product){

        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(
                () -> {

                    double price = calculatePrice(product);
                    futurePrice.complete(price);
                }
        ).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsync1(String prodcut){
        return CompletableFuture.supplyAsync( () -> calculatePrice(prodcut));
    }

    private double calculatePrice(String product){
        Util.delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
