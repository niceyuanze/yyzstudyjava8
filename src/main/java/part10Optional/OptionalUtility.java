package part10Optional;

import java.util.Optional;

/**
 * Created by niceyuanze on 17-4-20.
 */
public class OptionalUtility {
    public static Optional<Integer> stringToInt(String s){
        try{
            return Optional.of(Integer.parseInt(s));
        }catch (NumberFormatException e){
            return Optional.empty();
        }
    }
}
