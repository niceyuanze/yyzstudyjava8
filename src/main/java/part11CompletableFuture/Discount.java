package part11CompletableFuture;

/**
 * Created by niceyuanze on 17-4-22.
 */
public class Discount {
    public enum Code{
        NONE(0), SILVER(5), GOLD(10), PLATIUM(15), DIAMOND(20);

        private final int percentage;
        Code(int percentage){
            this.percentage = percentage;
        }

    }

    public static String applyDiscount(Quote quote){

        return quote.getShopName() + " price is " +
                Discount.apply( quote.getPrice(),
                                    quote.getDiscountCode());
    }

    private static double apply(double price, Code code){
        Util.delay();
        return price * (100 - code.percentage) / 100;
    }
}
