package part9DefaultMethod;

/**
 * Created by niceyuanze on 17-4-19.
 */
public interface A {
    default public void hello(){
        System.out.println("Hello from A");
    }
}
