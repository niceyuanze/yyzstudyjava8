package part9DefaultMethod;

/**
 * Created by niceyuanze on 17-4-19.
 */
public interface Father {
    default void x(){
        System.out.println("x");
    }

    default void y(){
        System.out.println("y");
    }

    default void z(){
        System.out.println("z");
    }

}
