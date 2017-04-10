package part2;

import commons.Apple;
import part1.FilteringApples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by niceyuanze on 17-4-8.
 */
public class Main {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort( (a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        inventory.sort( Comparator.comparing( (a) -> a.getWeight()));
        inventory.sort(Comparator.comparing(Apple::getWeight));


        Integer[] x = null;

        try{
            System.out.println(x.clone());
        }catch (NullPointerException e){
            System.out.println("???1");
        }

        System.out.println("???2");

    }
}
