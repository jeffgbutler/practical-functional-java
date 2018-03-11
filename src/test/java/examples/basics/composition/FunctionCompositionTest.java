package examples.basics.composition;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import solutions.basics.immutable.ImmutablePerson;

public class FunctionCompositionTest {

    // create a basic concatenation function
    private BiFunction<String, String, String> concat = (a, b) -> a + " " + b;
    
    // create a new function that calls the concatenation function, but
    // provides the first parameter as a constant
    private Function<String, String> hello = a -> concat.apply("Hello", a);

    @Test
    public void testConcat() {
        String phrase = concat.apply("Hello", "Fred");
        
        assertThat(phrase).isEqualTo("Hello Fred");
    }

    @Test
    public void testHello() {
        String phrase = hello.apply("Fred");
        
        assertThat(phrase).isEqualTo("Hello Fred");
    }
    
    @Test
    public void testHelloInStream() {
        String answer = Stream.of(ImmutablePerson.of("Fred", "Flintstone"),
                                  ImmutablePerson.of("Barney", "Rubble"))
                .map(ImmutablePerson::getFirstName)
                .map(hello)
                .collect(Collectors.joining(", "));

        assertThat(answer).isEqualTo("Hello Fred, Hello Barney");
    }
}
