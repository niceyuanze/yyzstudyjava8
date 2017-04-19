package parallelAndPerformance;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by niceyuanze on 17-4-17.
 */
public class ParallelStreams {

    public static long sequentialSum(long n){

        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long rangedSum(long n){
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n){
        long result = 0;
        for(long i = 1L; i <= n; i++){
            result += i;
        }
        return result;
    }

    public static long parallelSum(long n){

        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);

    }

    public static long parallelRangedSum(long n){
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);

    }

    public long measureSumPerf(Function<Long, Long> adder, long n){

        long fastest = Long.MAX_VALUE;
        for(int i = 0; i < 10; i++){
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if( duration < fastest) fastest = duration;
        }
        return fastest;

    }


    public static long sideEffectSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }
    public static void main(String[] args) {
        ParallelStreams p = new ParallelStreams();

        System.out.println("SideEffect parallel sum done in " +
                p.measureSumPerf(ParallelStreams::sideEffectParallelSum,10_000_000L) + "msecs");

//        System.out.println("sequentialSum: " + p.measureSumPerf(ParallelStreams::sequentialSum,10_000_000));
//        System.out.println("rangedSum: " + p.measureSumPerf(ParallelStreams::rangedSum,10_000_000));
//        System.out.println("parallelRangedSum: " + p.measureSumPerf(ParallelStreams::parallelRangedSum,10_000_000));
//        System.out.println("iterativeSum: " + p.measureSumPerf(ParallelStreams::iterativeSum,10_000_000));
//        System.out.println("parallelSum: " + p.measureSumPerf(ParallelStreams::parallelSum,10_000_000));

    }

}
