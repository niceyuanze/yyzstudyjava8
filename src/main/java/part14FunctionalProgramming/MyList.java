package part14FunctionalProgramming;

import java.util.function.Predicate;

/**
 * Created by niceyuanze on 17-5-4.
 */
public interface MyList<T> {

    T head();

    MyList<T> tail();

    MyList<T> filter(Predicate<T> p);

    default boolean isEmpty(){
        return true;
    }


}
