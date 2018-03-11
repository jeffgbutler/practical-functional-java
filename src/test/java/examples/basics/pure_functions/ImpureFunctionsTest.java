package examples.basics.pure_functions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import solutions.basics.immutable.ImmutablePerson;

public class ImpureFunctionsTest {

    @Test
    public void testImpureFunction() {
        List<ImmutablePerson> allPeople = new ArrayList<>();
        addTheFlintstones(allPeople);
        addTheRubbles(allPeople);
        
        assertThat(allPeople.size()).isEqualTo(4);
        assertThat(allPeople.get(1).getFirstName()).isEqualTo("Wilma");
        assertThat(allPeople.get(3).getFirstName()).isEqualTo("Betty");
    }
    
    private void addTheFlintstones(List<ImmutablePerson> people) {
        people.add(ImmutablePerson.of("Fred", "Flintstone"));
        people.add(ImmutablePerson.of("Wilma", "Flintstone"));
    }

    private void addTheRubbles(List<ImmutablePerson> people) {
        people.add(ImmutablePerson.of("Barney", "Rubble"));
        people.add(ImmutablePerson.of("Betty", "Rubble"));
    }
}
