package exercises.basics.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamExercises {

    public List<String> toUpperCase(List<String> strings) {
        // TODO - return a List of strings that are the input strings upper cased
        return null;
    }
    
    public String calculateOrderSummary(List<Order> orders) {
        // TODO - return a String like "Fred ordered 1 Baseball and 1 glove" for each order, joined with \n
        return null;
    }
    
    public int calculateTotalOrdered(List<Order> orders, String productName) {
        // TODO - return the total quantity of products ordered that match the input name
        //
        // hint: us the mapToInt(ToIntFunction) function to transform an object stream to an IntStream,
        // then use the sum function.  For example: see the mapToIntAndSumExample function below
        
        return 0;
    }
    
    protected int mapToIntAndSumExample() {
        return Stream.of("12", "34", "56")    // Stream<String> ("12", '34", "56")
                .mapToInt(Integer::parseInt)  // IntStream (12, 34, 56)
                .sum();                       // 12 + 34 + 56 = 102
    }
}
