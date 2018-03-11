package examples.basics.pure_functions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import solutions.basics.immutable.ImmutablePerson;

public class PurePureFunctionsTest {

    @Test
    public void testPureFunction() {
        List<ImmutablePerson> allPeople = Stream.of(getTheFlintstones(), getTheRubbles())
                .flatMap(Function.identity())
                .collect(Collectors.toList());
        
        assertThat(allPeople.size()).isEqualTo(4);
        assertThat(allPeople.get(1).getFirstName()).isEqualTo("Wilma");
        assertThat(allPeople.get(3).getFirstName()).isEqualTo("Betty");
    }
    
    private Stream<ImmutablePerson> getTheFlintstones() {
        return Stream.of(ImmutablePerson.of("Fred", "Flintstone"),
                ImmutablePerson.of("Wilma", "Flintstone"));
    }

    private Stream<ImmutablePerson> getTheRubbles() {
        return Stream.of(ImmutablePerson.of("Barney", "Rubble"),
                ImmutablePerson.of("Betty", "Rubble"));
    }
}
