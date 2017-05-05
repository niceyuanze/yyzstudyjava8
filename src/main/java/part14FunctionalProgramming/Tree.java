package part14FunctionalProgramming;

/**
 * Created by niceyuanze on 17-5-4.
 */
public class Tree {

    private String key;

    private int val;

    private Tree left, right;

    public Tree(String k, int v, Tree l, Tree r){
        key = k;
        val = v;
        left = l;
        right = r;
    }

}
