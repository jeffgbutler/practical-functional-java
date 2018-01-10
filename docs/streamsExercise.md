# Streams Exercises

The goal of the exercises is to help you review basic Stream operations like map, filter, flatMap, and collect.

Solutions are available in `src/main/java/solutions/basics/streams/StreamExercises.java`

## Exercises

The exercise is to fix the code in `src/main/java/exercises/basics/streams/StreamExercises.java` to enable the tests to pass.

1. Remove the @Ignore annotation from the test in `src/test/java/exercises/basics/streams/StreamTest.java` this will enable three failing unit tests
2. The `toUpperCase` method is relatively simple to fix with a map and `Collectors.toList()`.  This will resolve one unit test
3. Fix the `calculateOrderSummary` method this way:
   - Create a method `private String getProductDetail(Order order)` that returns a string like "1 Baseball and 1 glove" for the order.  This is accomplished with map and the `Collectors.joining` collector
   - Create a method `private String toOrderSummary(Order order)` that returns a string like "Fred ordered 1 Baseball and 1 glove" for the order.  This is simple string concatenation using the above method
   - Finally, complete the `public String calculateOrderSummary(List<Order> orders)` method with a map using the method above and the `Collectors.joining` collector.  This method returns a string for every order, joined with the newline character.  This will resolve one more unit test.
4. The `public int calculateTotalOrdered(List<Order> orders, String productName)` method can be completed with one chained pipeline including flatMap, filter, mapToInt, and sum.  See the example in the code for an understanding of how mapToInt works.
 
