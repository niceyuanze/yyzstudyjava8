package part9DefaultMethod;

/**
 * Created by niceyuanze on 17-4-19.
 */
public interface Moveable {

    int getX();

    int getY();

    void setX(int x);

    void setY();

    default void moveHorizontally(int distance){
        setX(getX() + distance);
    }
}
