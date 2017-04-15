package part5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by niceyuanze on 17-4-13.
 */
public class ConstructStream {

    public static void main(String[] args) throws IOException {
        Stream<String> stringStream = Stream.of("Java 8", "Lambdas ","In "+" Action");
        stringStream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();

        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        long uniqueWords = 0;
        Files.lines(Paths.get("/home/niceyuanze/Desktop/123"), Charset.defaultCharset())
                .flatMap(x -> Arrays.stream(x.split(" ")))
                .forEach(System.out::println);

        Stream.iterate(0, n -> n+2)
                .limit(10)
                .forEach(System.out::println);


        Stream.iterate(new int[]{0,1},n->new int[]{n[1],n[0]+n[1]})
                .limit(10)
                .forEach(n -> System.out.println("( " + n[0] +", "+n[1]+ " )"));

        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        IntStream ones = IntStream.generate(() -> 1);


        IntSupplier fib = new IntSupplier() {

            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {

                int old = this.current;
                this.current = this.previous + this.current;
                this.previous = old;
                return this.previous;
            }
        };

        IntStream.generate(fib).limit(10).forEach(System.out::println);

    }
}
