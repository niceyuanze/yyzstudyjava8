package part8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by niceyuanze on 17-4-19.
 */
public class Debug {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(2, 3, 4, 5);
        integers.stream()
                .peek(x -> System.out.println("from stream: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit: " + x))
                .forEach(System.out::println);


        /*
        Exception in thread "main" java.lang.ArithmeticException: / by zero
	at part8.Debug.divideByZero(Debug.java:22)
	at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193)
	at java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:948)
	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:481)
	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:471)
	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151)
	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174)
	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:418)
	at part8.Debug.main(Debug.java:13)
         */
//        List<Integer> numbers = Arrays.asList(1, 2, 3);
//        numbers.stream().map(Debug::divideByZero).forEach(System.out::println);



//        List<Point> points = Arrays.asList(new Point(12,2),null);
//        points.stream().map( Point::getX).forEach(System.out::println);
    }

    public static int divideByZero(int n){
        return n / 0;
    }
}
