package part11CompletableFuture;

import java.util.Random;

/**
 * Created by niceyuanze on 17-4-21.
 */
public class Util {

    private static final Random random = new Random();

    public static void delay(){

        int delay = 500 + random.nextInt(2000);
        try{
            Thread.sleep(delay);
        } catch (InterruptedException e){
            throw new RuntimeException();
        }

    }


}
