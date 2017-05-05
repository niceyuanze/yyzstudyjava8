package part10Optional;

import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * Created by niceyuanze on 17-4-20.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(tableSizeFor(9));



    }
    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;


    }

    public static int readDuration(Properties props, String name){
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalUtility::stringToInt)
                .filter( i -> i > 0)
                .orElse(0);

//        String value = props.getProperty(name);
//
//        if( value != null){
//            try{
//                int i = Integer.parseInt(value);
//                if( i > 0){
//                    return i;
//                }
//            }catch (NumberFormatException nfe){}
//        }
//
//        return 0;
    }

    public String GetCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                    .flatMap(Car::getInsurance)
                    .map(Insurance::getName)
                    .orElse("UnKnown");


    }

    public static Optional<Integer> stringToInt(String s){



        return Optional.of(Integer.parseInt(s));
    }



    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car){
        if( person.isPresent() && car.isPresent()){
            return null;
        }
        return null;
    }
}
