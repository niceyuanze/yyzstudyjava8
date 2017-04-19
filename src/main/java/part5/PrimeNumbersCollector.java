package part5;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * Created by niceyuanze on 17-4-17.
 */
public class PrimeNumbersCollector implements Collector<Integer,
        Map<Boolean, List<Integer>>,
        Map<Boolean,List<Integer>> > {


    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>() {
            {
                put(true, new ArrayList<Integer>());
                put(false, new ArrayList<Integer>());
            }
        };
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get( isPrime(acc.get(true), candidate))
                    .add(candidate);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {

//        throw new UnsupportedOperationException("yyz is the most good looking");
        return (Map<Boolean, List<Integer>> map1,
                    Map<Boolean, List<Integer>> map2) ->{
         map1.get(true).addAll(map2.get(true));
         map1.get(false).addAll(map2.get(false));
         return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    public <A> List<A> takeWhile(List<A> list, Predicate<A> p){
        int i = 0;
        for(A item: list){
            if( !p.test(item)){
                return list.subList(0,i);
            }
            i++;
        }
        return list;
    }

    public boolean isPrime( List<Integer> primes, int candidate){

        int candidateRoot = (int)Math.sqrt((double)candidate);
        return takeWhile(primes, i -> i<= candidateRoot)
                .stream()
                .noneMatch(p -> candidate % p == 0);
    }



    public static void main(String[] args) {
//        long fastest = Long.MAX_VALUE;
//        for(int i = 0; i < 10; i++){
//            System.out.println("-------------------------------");
//            long start = System.nanoTime();
//            IntStream.rangeClosed(2, 1_000_000).boxed().collect(new PrimeNumbersCollector());
//            long duration = (System.nanoTime() - start) / 1_000_000;
//            System.out.println(duration);
//
//            start = System.nanoTime();
//            IntStream.rangeClosed(2, 1_000_000).boxed().
//                    collect(partitioningBy( candidate -> StudyPartition.isPrime(candidate)));
//            duration = (System.nanoTime() - start) / 1_000_000;
//            System.out.println(duration);
//
//        }
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
