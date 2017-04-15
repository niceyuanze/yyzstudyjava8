package part5;

import commons.Dish;
import commons.Trader;
import commons.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by niceyuanze on 17-4-13.
 */
public class SolveBusiness {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> transactions11 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(transactions11);

        System.out.println("\n\n");
        List<String> travelCitys = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(travelCitys);

        System.out.println("\n\n");
        List<Trader> CambridgeTraders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> "Cambridge".equals(t.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());


        System.out.println("\n\n");
        String traderNames = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("",(all,name) -> all+" "+name);
        System.out.println(traderNames);

//        boolean whetherWorkInmilan =  transactions.stream()
//                .map(Transaction::getTrader)
//                .anyMatch( t -> t.getCity() == "milan");
        boolean whetherWorkInmilan =  transactions.stream()
                .anyMatch( transaction -> "Milan".equals(transaction.getTrader().getName()));

        System.out.println("\n\n");
        Integer sumValue = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(0,(x,y)->x+y);
        System.out.println(sumValue);


        System.out.println("\n\n");

        List<Integer> xxx=  transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
        System.out.println(xxx);

        Optional maxValue = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(maxValue.get());

        int calories = Dish.menu.stream().map(Dish::getCalories).reduce(0,Integer::sum);

        calories = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
        IntStream  intStream = Dish.menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();


        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter( n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

        IntStream.rangeClosed(1,100).boxed().flatMap(a -> IntStream.rangeClosed(a,100)
                .mapToObj(b -> new double[]{a,b, Math.sqrt(a*a+b*b)}))
                .filter(x -> x[2] % 1 == 0)
                .forEach(x -> System.out.println(x[0] + " " + x[1]+" "+x[2]));
        System.out.println(2.1 % 1);
        System.out.println(2.1 % 1.0);






    }



}
