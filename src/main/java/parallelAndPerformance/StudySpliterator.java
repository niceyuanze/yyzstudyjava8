package parallelAndPerformance;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by niceyuanze on 17-4-18.
 */
public class StudySpliterator {

    public static final String SENTENCE = " Nel     madsf asdfasdfsadfsd s d " +
            "sfasdfasd asd    asdfasdf " +
            "asfdsadfsadf asdfasd  asfd  asdf asdf sdf sdaf asfdf asdf asdf ";
    public static int countWordsIteratively(String s){
        int counter = 0;
        boolean lastSpace = false;
        for(char c: s.toCharArray()){
            if(Character.isWhitespace(c)){
                lastSpace = true;
            }else {
                if(lastSpace) counter++;
                lastSpace = false;
            }

        }
        return counter;

    }

    public  class WordCounter{
        private final int counter;
        private final boolean lastSpace;

        public WordCounter(int counter, boolean lastSpace){
            this.counter = counter;
            this.lastSpace = lastSpace;
        }

        public WordCounter accumulate(Character c){
            if(Character.isWhitespace(c)){
                return lastSpace ? this:new WordCounter(counter, true);
            } else{
                return lastSpace ? new WordCounter(counter + 1, false):this;
            }
        }
        public WordCounter combine(WordCounter wordCounter){
            return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
        }
        public int getCounter(){
            return counter;
        }



    }





    public  int countWords(Stream<Character> stream){
        IntStream.rangeClosed(0,10).reduce(0,StudySpliterator::sum);
        WordCounter wordCounter = stream.reduce(new WordCounter(0,true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();


    }

    public static int sum(int a, int b) {
        return a + b;
    }






    public static void main(String[] args) {


        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);

        StudySpliterator s = new StudySpliterator();
        System.out.println(s.countWordsByNotNew(stream));

    }

    public static WordCounterNotNew accumulate(WordCounterNotNew c){

        return new WordCounterNotNew(0,true);
    }


    //StudySpliterator
    public  int countWordsByNotNew(Stream<Character> stream){
        WordCounterNotNew wordCounterNotNew = stream.reduce(
                new WordCounterNotNew(0,true),
                WordCounterNotNew::accumulate,
                WordCounterNotNew::combine
        );
        return wordCounterNotNew.getCounter();
    }


    public static class WordCounterNotNew{
        private  int counter;

        private   boolean lastSpace;

        public WordCounterNotNew(int counter, boolean lastSpace){
            this.counter = counter;
            this.lastSpace = lastSpace;
        }

        public  WordCounterNotNew accumulate(Character c){
            System.out.println("111");
            if(Character.isWhitespace(c)){
                setLastSpace(true);
            }else{
                if(lastSpace == true){
                    System.out.println("222");

                    setCounter(getCounter()+1);
                    setLastSpace(false);
                }
            }
            return this;
        }

        public WordCounterNotNew combine(WordCounterNotNew wordCounter){
            return this;
        }


        public  int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public  boolean isLastSpace() {
            return lastSpace;
        }

        public  void setLastSpace(boolean lastSpace) {
            this.lastSpace = lastSpace;
        }
    }





}
