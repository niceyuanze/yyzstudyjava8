package part8;

/**
 * Created by niceyuanze on 17-4-19.
 */
public interface Subject {
    void registerObserver(Observer o);
    void notifyObervers(String tweet);
}
