package part8;

import commons.Dish;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

/**
 * Created by niceyuanze on 17-4-19.
 */
public class Refactor {


    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(""))){
            return p.process(br);
        }
    }


    public static void doSomething(Runnable r){
        r.run();
    }

    public static void doSomething(Task a){
        a.execute();
    }




    public static void main(String[] args) throws IOException {
        String oneLine = processFile( p -> p.readLine() + p.readLine() );


        Dish.menu.parallelStream().filter( d -> d.getCalories() > 300)
                .map(Dish::getName)
                .collect(toList());

        int totalCalories = Dish.menu.stream().collect(summingInt(Dish::getCalories));


        doSomething((Task)() -> System.out.println("Danger danger"));


        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("sadfsadfasdf");
            }
        });


        Runnable r2 = () -> System.out.println("Hello");

        int a = 10;
        Runnable r1 = () -> {
//            int a = 2;
            System.out.println(a);
        };

        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                int a = 3;
                System.out.println(a);
            }
        };



    }
}
