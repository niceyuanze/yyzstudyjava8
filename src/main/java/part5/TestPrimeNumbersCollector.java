package part5;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by niceyuanze on 17-4-17.
 */
public class TestPrimeNumbersCollector {

    public static void main(String[] args) {

    }
    public Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n){
        return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
    }
}
