package part4;

import commons.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by niceyuanze on 17-4-9.
 */
public class StreamBasic {

    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames =
                Dish.menu.stream().
                        filter(d -> d.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);

        System.out.println("\n\n\n\n\n");
        List<Dish> vegetarianMenu = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());


        System.out.println("\n\n\n\n\n");


        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers = numbers.stream()
                .distinct()
                .filter( i ->i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(numbers);

        System.out.println("\n\n\n\n\n");

        List<String> dishNames = Dish.menu
                .stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());


        System.out.println("\n\n\n\n\n");
        List<Integer> dishNameLengths = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());

         


    }
}