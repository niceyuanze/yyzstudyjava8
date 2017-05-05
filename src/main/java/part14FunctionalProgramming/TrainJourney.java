package part14FunctionalProgramming;

/**
 * Created by niceyuanze on 17-5-4.
 */
public class TrainJourney {

    public int price;

    public TrainJourney onward;

    public TrainJourney(int p, TrainJourney t){
        price = p;
        onward = t;
    }
    static TrainJourney link( TrainJourney a, TrainJourney b){
        if( a == null) return b;

        TrainJourney t = a;
        while( t.onward != null){
            t = t.onward;
        }
        t.onward = b;
        return a;

    }
}
