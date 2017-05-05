package part14FunctionalProgramming;

import java.util.stream.IntStream;

/**
 * Created by niceyuanze on 17-5-4.
 */
public class FindPrimeRecusive {

    public static void main(String[] args) {
    }


    static IntStream primes(IntStream stream){
        int head = head(numbers());
        return IntStream.concat(IntStream.of(head),
                primes( tail(numbers())).filter(n -> n % head != 0));
    }



    static IntStream numbers(){
        return IntStream.iterate(2, n -> n + 1);
    }



    static int head(IntStream numbers){
        return numbers.findFirst().getAsInt();
    }


    static IntStream tail(IntStream numbers){
        return numbers.skip(1);
    }
}
