package utilities;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface Utils {

    /**
     * Turns an Iterable into a Stream.  There is no built-in JDK method to do this - probably because it is not
     * always clear whether the stream can be parallel or not.
     * 
     * @param iterable any Iterable
     * @return a Stream based on the Iterable
     */
    static <T> Stream<T> stream(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
