package part8;

/**
 * Created by niceyuanze on 17-4-19.
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point moveRightBy(int x){
        return new Point(this.x + x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
