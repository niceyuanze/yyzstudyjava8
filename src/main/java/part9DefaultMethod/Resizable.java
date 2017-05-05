package part9DefaultMethod;

/**
 * Created by niceyuanze on 17-4-19.
 */
public interface Resizable {

    int getWidth();

    int getHeight();

    void setWidth(int width);

    void setHeight(int height);

    void setAbsoluteSize(int width, int height);

    default void setRelativeSize(int wFactor, int hFactor){
        setAbsoluteSize(getWidth() / wFactor, getHeight() / hFactor);
    }

}
