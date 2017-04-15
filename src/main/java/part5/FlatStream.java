package part5;

import commons.Dish;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by niceyuanze on 17-4-12.
 */
public class FlatStream {

    public static void main(String[] args) {
        String[] words = {"Hello","World"};
        System.out.println(Arrays.stream(words)
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList()));
        System.out.println(Arrays.stream(words).map(word -> word.split(""))
                                                .map(Arrays::stream)
                                                    .distinct()
                                                    .collect(Collectors.toList())

        );

        Integer[] a = {1,2,3};
        Integer[] b = {4,5};
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(4,5);
        numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i,j}));


        Arrays.stream(a).flatMap(i -> Arrays.stream(b).map(j -> new int[]{i,j}));

        System.out.println("\n\n\n\n\n");


        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("1");
        }

        if(Dish.menu.stream().allMatch( d -> d.getCalories() > 1000)){
            System.out.println("2");
        }

        if(Dish.menu.stream().noneMatch( d-> d.getCalories() >= 1000)){
            System.out.println(3);
        }

        Dish.menu.stream().filter(Dish::isVegetarian).findAny()
                .ifPresent(d -> System.out.println(d.getName()));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map( x -> x * x)
                .filter( x -> x % 3 == 0)
                .findFirst();
        System.out.println(firstSquareDivisibleByThree.orElse(2));


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        numbers.stream().reduce(1, (c, d) -> c * d);

        System.out.println(numbers.stream().reduce(1, (c, d) -> c * d));
//        numbers.stream().reduce(0,(int a, int b) -> a + b);

//        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4);

        System.out.println(numbers.stream().reduce((x1, x2) -> x1 > x2?x1:x2));
    }
}
