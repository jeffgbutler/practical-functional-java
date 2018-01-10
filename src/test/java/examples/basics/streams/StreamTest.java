package examples.basics.streams;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import solutions.basics.immutable.ImmutablePerson;

public class StreamTest {

    // Streams can be created from a list
    private Stream<ImmutablePerson> getTheFlintstones() {
        List<ImmutablePerson> people = new ArrayList<>();
        
        people.add(ImmutablePerson.of("Fred", "Flintstone"));
        people.add(ImmutablePerson.of("Wilma", "Flintstone"));
        people.add(ImmutablePerson.of("Pebbles", "Flintstone"));

        return people.stream();
    }

//    Streams can be created from a list a bit easier in Java 9
//    private Stream<Person> getTheFlintstonesJava9() {
//        return List.of(Person.of("Barney", "Rubble"),
//                Person.of("Betty", "Rubble"),
//                Person.of("Bamm Bamm", "Rubble"))
//                .stream();
//    }
    
    // Streams can be created directly with the "of" method
    private Stream<ImmutablePerson> getTheRubbles() {
        return Stream.of(ImmutablePerson.of("Barney", "Rubble"),
                ImmutablePerson.of("Betty", "Rubble"),
                ImmutablePerson.of("Bamm Bamm", "Rubble"));
    }
    
    // the "collect" method can be used to turn a stream into a List
    @Test
    public void testCollect() {
        List<ImmutablePerson> flintstones = getTheFlintstones()
                .collect(Collectors.toList());
        
        assertThat(flintstones.size()).isEqualTo(3);
        assertThat(flintstones.get(1).getFirstName()).isEqualTo("Wilma");
    }
    
    // the "filter" method is used to create a new stream containing only items that match the filter
    @Test
    public void testFilterConciseLambda() {
        List<ImmutablePerson> flintstones = getTheFlintstones()
                .filter(p -> p.getFirstName().equals("Fred") || p.getFirstName().equals("Wilma"))
                .collect(Collectors.toList());
        
        assertThat(flintstones.size()).isEqualTo(2);
        assertThat(flintstones.get(1).getFirstName()).isEqualTo("Wilma");
    }

    // the "filter" method is used to create a new stream containing only items that match the filter
    @Test
    public void testFilterWithMethodReference() {
        List<ImmutablePerson> flintstones = getTheFlintstones()
                .filter(this::isFredOrWilma)
                .collect(Collectors.toList());
        
        assertThat(flintstones.size()).isEqualTo(2);
        assertThat(flintstones.get(1).getFirstName()).isEqualTo("Wilma");
    }
    
    private boolean isFredOrWilma(ImmutablePerson p) {
        return p.getFirstName().equals("Fred") || p.getFirstName().equals("Wilma");
    }
    
    // the "map" method is used to transform a stream from one type to another
    @Test
    public void getMap() {
        String directoryListing = getTheFlintstones()
                .map(this::personAsString)  // Stream<ImmutablePerson> -> Stream<String>
                .collect(Collectors.joining("\n"));
        
        String expected = "Flintstone, Fred\n"
                + "Flintstone, Wilma\n"
                + "Flintstone, Pebbles";
        
        assertThat(directoryListing).isEqualTo(expected);
    }
    
    private String personAsString(ImmutablePerson person) {
        return person.getLastName() + ", " + person.getFirstName();
    }

    // the "sorted" method is used to reorder a Stream
    // can supply a lambda for the sort function, or use
    // the natural order of a comparable
    @Test
    public void testSorted() {
        String directoryListing = getTheFlintstones()
                .sorted((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()))
                .map(this::personAsString)
                .collect(Collectors.joining("\n"));
        
        String expected = "Flintstone, Fred\n"
                + "Flintstone, Pebbles\n"
                + "Flintstone, Wilma";
        
        assertThat(directoryListing).isEqualTo(expected);
    }

    // stream methods can be chained together
    @Test
    public void testStreamMethodChaining() {
        String directoryListing = getTheFlintstones()
                .filter(this::isFredOrWilma)
                .sorted((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()))
                .map(this::personAsString)
                .collect(Collectors.joining("\n"));
        
        String expected = "Flintstone, Fred\n"
                + "Flintstone, Wilma";
        
        assertThat(directoryListing).isEqualTo(expected);
    }
    
    // the skip function can be used to skip over items in a stream
    @Test
    public void testSkip() {
        String directoryListing = getTheFlintstones()
                .skip(1)
                .filter(this::isFredOrWilma)
                .sorted((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()))
                .map(this::personAsString)
                .collect(Collectors.joining("\n"));
        
        String expected = "Flintstone, Wilma";
        
        assertThat(directoryListing).isEqualTo(expected);
    }
    
    // flatMap is used to apply a many to one mapping 
    @Test
    public void testFlatMap1() {
        ImmutablePerson fred = ImmutablePerson.of("Fred", "Flintstone");
        fred = fred.withNickNames("The Fredmeister", "Yabba Dabba Dude");
        
        ImmutablePerson barney = ImmutablePerson.of("Barney",  "Rubble");
        barney = barney.withNickNames("The Barnster", "Little Buddy");

        String expectedAllNickNames = "The Fredmeister,Yabba Dabba Dude,"
                + "The Barnster,Little Buddy";
        
        // (not so good) map each ImmutablePerson to a Stream<String> of nicknames,
        // then use flatMap for flatten
        String allNickNames = Stream.of(fred, barney)  // Stream<ImmutablePerson>
                .map(ImmutablePerson::nickNames)  // Stream<Stream<String>>
                .flatMap(Function.identity()) // Stream<String>
                .collect(Collectors.joining(","));
        
        assertThat(allNickNames).isEqualTo(expectedAllNickNames);
    }

    // flatMap is used to apply a many to one mapping 
    @Test
    public void testFlatMap2() {
        ImmutablePerson fred = ImmutablePerson.of("Fred", "Flintstone");
        fred = fred.withNickNames("The Fredmeister", "Yabba Dabba Dude");
        
        ImmutablePerson barney = ImmutablePerson.of("Barney",  "Rubble");
        barney = barney.withNickNames("The Barnster", "Little Buddy");

        String expectedAllNickNames = "The Fredmeister,Yabba Dabba Dude,"
                + "The Barnster,Little Buddy";
        
        // (better) use flatMap instead of map with the mapping function
        String allNickNames = Stream.of(fred, barney)  // Stream<ImmutablePerson>
                .flatMap(ImmutablePerson::nickNames)  // Stream<String>
                .collect(Collectors.joining(","));
        
        assertThat(allNickNames).isEqualTo(expectedAllNickNames);
    }

    // streams can be concatenated with the concat method
    @Test
    public void testConcatenationWithConcat() {
        // concat is OK to use when concatenating two streams, but can cause problems
        // with multiple streams and recursion.  There is a warning in the JavaDocs
        // about being careful with concat.  If you have multiple streams to concatenate,
        // then it is better to use the flatMap technique below.
        List<ImmutablePerson> allPeople = Stream.concat(getTheFlintstones(), getTheRubbles())
                .collect(Collectors.toList());

        assertThat(allPeople.size()).isEqualTo(6);
        assertThat(allPeople.get(1).getFirstName()).isEqualTo("Wilma");
        assertThat(allPeople.get(4).getFirstName()).isEqualTo("Betty");
    }
    
    // streams can also be concatenated with flatMap
    @Test
    public void testConcatenationWithFlatMap() {
        List<ImmutablePerson> allPeople = Stream.of(getTheFlintstones(), getTheRubbles())
                .flatMap(Function.identity())
                .collect(Collectors.toList());

        assertThat(allPeople.size()).isEqualTo(6);
        assertThat(allPeople.get(1).getFirstName()).isEqualTo("Wilma");
        assertThat(allPeople.get(4).getFirstName()).isEqualTo("Betty");
    }

    // the Stream.forEach method is for side effects.  We don't want side effects,
    // so don't do this
    @Test
    public void testForEach() {
        StringBuilder sb = new StringBuilder();
        
        getTheFlintstones().forEach(p -> {
            sb.append(personAsString(p));
            sb.append("\n"); // no good way to tell if we are at the end of the stream
        });

        String expected = "Flintstone, Fred\n"
                + "Flintstone, Wilma\n"
                + "Flintstone, Pebbles\n"; // note the extra \n at the end
        
        assertThat(sb.toString()).isEqualTo(expected);
    }
}
