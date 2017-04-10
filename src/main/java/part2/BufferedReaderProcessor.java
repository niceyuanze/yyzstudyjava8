package part2;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by niceyuanze on 17-4-8.
 */

@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;

}
