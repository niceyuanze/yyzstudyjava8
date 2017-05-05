package part10Optional;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Created by niceyuanze on 17-4-20.
 */
public class Person {
    private Optional<Car> car;

    public void setCar(Optional<Car> car) {
        this.car = car;
    }

    public Optional<Car> getCar(){
        return car;
    }
}
