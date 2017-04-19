package part5;

import commons.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Created by niceyuanze on 17-4-16.
 */
public class StudyPartition {

    public static boolean isPrime(int candidate){
        int candidateRoot = (int)Math.sqrt((double)candidate);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch( x -> candidate % x == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2, n).boxed().collect(partitioningBy( candidate -> isPrime(candidate)));
    }

    public static void main(String[] args) {

        Stream<Dish> menuStream = Dish.menu.stream();

        List<Dish> dishes = menuStream.collect(toList());

        Set<Dish> dishesSet = menuStream.collect(toSet());

        Collection<Dish> dishesArrayList= menuStream.collect(toCollection(ArrayList::new));

        long howManyDishes = menuStream.collect(counting());

        int totalCalories = menuStream.collect(summingInt(Dish::getCalories));

        double avgCalories = menuStream.collect(averagingDouble(Dish::getCalories));

        IntSummaryStatistics menuStatistics = menuStream.collect(summarizingInt(Dish::getCalories));

        String shortMenu = menuStream.map(Dish::getName).collect(joining(", "));

        Optional<Dish> fattest = menuStream.collect(maxBy(comparing(Dish::getCalories)));

        int totalCalories1 = menuStream.collect(reducing(0, Dish::getCalories, Integer::sum));

        int howManyDishes1 = menuStream.collect(collectingAndThen(toList(), List::size));

        Map<Dish.Type, List<Dish>> dishesByType = menuStream.collect(groupingBy(Dish::getType));

        Map<Boolean, List<Dish>> vegetarianDishes = menuStream.collect(partitioningBy(Dish::isVegetarian));





    }
}
