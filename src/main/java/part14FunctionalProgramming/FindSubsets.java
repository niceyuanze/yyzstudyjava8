package part14FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by niceyuanze on 17-5-4.
 */
public class FindSubsets {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        System.out.println(subsets(list));
    }


    static List<List<Integer>> subsets( List<Integer> list){
        // if the list is the null list, then return null list
        if( list.isEmpty()){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }

        Integer first = list.get(0);

        List<Integer> rest = list.subList(1, list.size());

        List< List<Integer>> subans = subsets(rest);

        List< List<Integer>> subbans2 = insertAll(first, subans);

        System.out.println("-------");
        System.out.println(first);
        System.out.println(subans);
        System.out.println(subbans2);
        System.out.println( concat(subans, subbans2));
        return concat(subans, subbans2);
    }


    static List< List<Integer>> insertAll(Integer first, List<List<Integer>> lists){

        List<List<Integer>> result = new ArrayList<>();

        for( List<Integer> list: lists){
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }

        return result;
    }

    static List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b){

        List<List<Integer>> r = new ArrayList<>(a);

        r.addAll(b);

        return r;
    }
}
