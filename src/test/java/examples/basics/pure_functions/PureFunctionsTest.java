package examples.basics.pure_functions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import solutions.basics.immutable.ImmutablePerson;

public class PureFunctionsTest {

    @Test
    public void testPureFunction() {
        List<ImmutablePerson> allPeople = new ArrayList<>();
        allPeople.addAll(getTheFlintstones());
        allPeople.addAll(getTheRubbles());
        
        assertThat(allPeople.size()).isEqualTo(4);
        assertThat(allPeople.get(1).getFirstName()).isEqualTo("Wilma");
        assertThat(allPeople.get(3).getFirstName()).isEqualTo("Betty");
    }
    
    private List<ImmutablePerson> getTheFlintstones() {
        List<ImmutablePerson> flintstones = new ArrayList<>();
        
        flintstones.add(ImmutablePerson.of("Fred", "Flintstone"));
        flintstones.add(ImmutablePerson.of("Wilma", "Flintstone"));

        return flintstones;
    }

    private List<ImmutablePerson> getTheRubbles() {
        List<ImmutablePerson> rubbles = new ArrayList<>();
        
        rubbles.add(ImmutablePerson.of("Barney", "Rubble"));
        rubbles.add(ImmutablePerson.of("Betty", "Rubble"));

        return rubbles;
    }
}
