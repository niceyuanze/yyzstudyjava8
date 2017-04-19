package part8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niceyuanze on 17-4-19.
 */
public class Feed implements Subject{

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObervers(String tweet) {
        observers.forEach( o -> o.notify(tweet));
    }

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.notifyObervers("money i cao ni man");
    }
}
