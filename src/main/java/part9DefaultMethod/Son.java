package part9DefaultMethod;

/**
 * Created by niceyuanze on 17-4-19.
 */
public class Son implements Father{

    @Override
    public void x(){
        System.out.println("asdfsadfadf");
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.x();
        son.y();
        son.z();
    }
}
