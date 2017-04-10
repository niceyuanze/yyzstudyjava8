package part1;

import commons.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by niceyuanze on 17-4-7.
 */
public class FilteringApples {






    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(90,"green"),
                new Apple(155,"green"),
                new Apple(120,"red"));


        List<Apple> greenApples = filterApples(inventory,(Apple apple) -> "green".equals(apple.getColor()));

        for(Apple apple: greenApples){
            System.out.println(apple);
        }
    }



    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<Apple>();

        for(Apple apple: inventory){
            if( p.test(apple)){
                result.add(apple);
            }


        }
        return result;


    }














}
