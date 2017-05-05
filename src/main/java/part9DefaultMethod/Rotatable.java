package part9DefaultMethod;

/**
 * Created by niceyuanze on 17-4-19.
 */
public interface Rotatable {


    void setRotationAngle(int angleInDegrees);


    int getRotationAngle();


    default void rotateBy(int angleInDegrees){
        setRotationAngle((getRotationAngle() + angleInDegrees) % 360);
    }
}
