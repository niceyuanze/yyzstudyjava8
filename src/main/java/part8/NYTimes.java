package part8;

/**
 * Created by niceyuanze on 17-4-19.
 */
public class NYTimes implements Observer{
    public void notify(String tweet){
        if( tweet != null && tweet.contains("money")){
            System.out.println("Breaking news in NY ! " + tweet);
        }

    }
}
