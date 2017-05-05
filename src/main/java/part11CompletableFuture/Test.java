package part11CompletableFuture;

/**
 * Created by niceyuanze on 17-4-21.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("1");
        new Thread(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("2");
    }
}
