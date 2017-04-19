package part5;

import commons.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

/**
 * Created by niceyuanze on 17-4-15.
 */
public class StudyCollector {

    public enum CaloricLevel{DIET, NORMARL, FAT}


    public static void main(String[] args) {
        long howManyDishes = Dish.menu.stream().collect(counting());
        System.out.println(howManyDishes);

        Comparator<Dish> dishCaloriesComparator = comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = Dish.menu.stream().collect(maxBy(dishCaloriesComparator));
        System.out.println(mostCalorieDish.get().getCalories());

        IntSummaryStatistics menuStatistics = Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics.getAverage() + " -" + menuStatistics.getCount() +" " + menuStatistics.getMax());
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(joining());
        System.out.println(shortMenu);

        shortMenu = Dish.menu.stream()
                .map(Dish::getName)
                .collect(reducing((s1, s2) -> s1 + s2))
                .get();

        shortMenu = Dish.menu.stream()
                .collect(reducing("", Dish::getName, (s1, s2) -> s1+s2));

        Map<Dish.Type, List<Dish>> dishesByByType = Dish.menu.stream()
                .collect(groupingBy(Dish::getType));

        Map<Dish.Type,Long> typesCount = Dish.menu.stream()
                .collect(groupingBy(Dish::getType, counting()));


        Map<Dish.Type, Optional<Dish>> mostCaloricByType = Dish.menu.stream()
                .collect(groupingBy( Dish::getType, maxBy(comparingInt( Dish::getCalories))));


        Map<Dish.Type, Optional<Dish>> mostCaloricByType2 = Dish.menu.stream()
                .collect(groupingBy( Dish::getType,
                        maxBy(comparingInt( Dish::getCalories))));

        Map<Dish.Type, Dish> mostCaloricByType1 = Dish.menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)),Optional::get)));


        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
                Dish.menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                            dish -> {
                                if(dish.getCalories() <= 400) return CaloricLevel.DIET;
                                else if(dish.getCalories() <= 700) return CaloricLevel.NORMARL;
                                else return CaloricLevel.FAT;
                            },toCollection(HashSet::new)
                        ))
                );
        
    }
}
