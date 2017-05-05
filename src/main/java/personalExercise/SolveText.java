package personalExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Map.Entry;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * Created by niceyuanze on 17-5-3.
 */
public class SolveText {
    public static final String classpath = SolveText.class.getResource("/").getPath();
    public static void find(String path) throws IOException {
        Stream<String> stream  = Files.lines(Paths.get(classpath+"wcTest_samll.txt"));
        System.out.println();
        stream.flatMap(line -> Stream.of(line.split(" ")))
                .collect(Collectors.groupingBy(x -> x));
        System.out.println(stream.flatMap(line -> Stream.of(line.split(" ")))
                .collect(Collectors.groupingBy(x -> x)));
//



    }

    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();




        Stream<String> stream  = Files.lines(Paths.get(classpath+"wcTest_samll.txt"));
        Map<String, Long> keyMap = stream.flatMap(line -> Stream.of( line.split(" ")))
                .collect(Collectors.groupingBy(x -> x,Collectors.counting()));

        keyMap = keyMap.entrySet().stream().sorted(Comparator.comparing(entry -> -entry.getValue()))
                .limit(1)
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
        System.out.println(keyMap);




//        keyMap.entrySet().stream().forEach( entry -> System.out.println(entry.getClass()));

//        keyMap.entrySet().stream()
//                .filter(entry -> entry.getKey().equals("b"));



//        keyMap = keyMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .limit(2)
//                .forEach( x -> x.g);



    }
}
