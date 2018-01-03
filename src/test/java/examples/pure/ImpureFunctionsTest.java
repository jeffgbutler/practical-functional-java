package examples.pure;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import examples.immutable.ImmutablePerson;

public class ImpureFunctionsTest {

    @Test
    public void testImpureFunction() {
        List<ImmutablePerson> allPeople = new ArrayList<>();
        addTheFlintstones(allPeople);
        addTheRubbles(allPeople);
        
        assertThat(allPeople.size()).isEqualTo(6);
        assertThat(allPeople.get(1).getFirstName()).isEqualTo("Wilma");
        assertThat(allPeople.get(4).getFirstName()).isEqualTo("Betty");
    }
    
    private void addTheFlintstones(List<ImmutablePerson> people) {
        people.add(ImmutablePerson.of("Fred", "Flintstone"));
        people.add(ImmutablePerson.of("Wilma", "Flintstone"));
        people.add(ImmutablePerson.of("Pebbles", "Flintstone"));
    }

    private void addTheRubbles(List<ImmutablePerson> people) {
        people.add(ImmutablePerson.of("Barney", "Rubble"));
        people.add(ImmutablePerson.of("Betty", "Rubble"));
        people.add(ImmutablePerson.of("Bamm Bamm", "Rubble"));
    }
}
