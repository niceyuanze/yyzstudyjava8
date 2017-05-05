package part14FunctionalProgramming;

import java.util.ArrayList;

/**
 * Created by niceyuanze on 17-5-4.
 */
public class TestLazyList {

    public static LazyList<Integer> from(int n){

        return new LazyList<>(n, () -> from(n+1));
    }



    public static void main(String[] args) {


        LazyList<Integer> numbers = from(2);
//        int two = primes(numbers).head();
//        int three = primes(numbers).tail().head();
        int four = primes(numbers).tail().tail().head();
//
//
//        System.out.println(two);
//        System.out.println(three);
        System.out.println(four);
    }

    public static MyList<Integer> primes( MyList<Integer> numbers){

        return new LazyList<>(
                numbers.head(),
                () -> primes(
                        numbers.tail().filter( n -> n % numbers.head() != 0)
                )

        );

    }
}
