package part2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by niceyuanze on 17-4-8.
 */
public class ProcessFileTest {

    public static void main(String[] args) throws IOException {
        String onLine = processFile( (BufferedReader br) -> br.readLine());
        String twoLines = processFile( (BufferedReader br) -> br.readLine() + br.readLine());

    }




    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }



}
