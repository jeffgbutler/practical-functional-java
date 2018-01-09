package examples.basics.lambdas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import examples.basics.immutable.SimpleImmutableObjectWithBuilder;

public class LambdaTest {
    
    // Lamba == Anonymous Class!
    
    // pre java 8 with a persistent comparator
    @Test
    public void testPersistentComparator() {
        List<SimpleImmutableObjectWithBuilder> testObjects = getTestObjects();
        
        testObjects.sort(new TestComparator());
        
        assertThat(testObjects.get(0).getDescription()).isEqualTo("Ash Tree");
        assertThat(testObjects.get(1).getDescription()).isEqualTo("Elm Tree");
        assertThat(testObjects.get(2).getDescription()).isEqualTo("Oak Tree");
    }
    
    private static class TestComparator implements Comparator<SimpleImmutableObjectWithBuilder> {
        @Override
        public int compare(SimpleImmutableObjectWithBuilder o1, SimpleImmutableObjectWithBuilder o2) {
            return o1.getId().compareTo(o2.getId());
        }
    }
    
    // pre java 8 with an anonymous class
    @Test
    public void testAnonymousClass() {
        List<SimpleImmutableObjectWithBuilder> testObjects = getTestObjects();
        
        testObjects.sort(new Comparator<SimpleImmutableObjectWithBuilder>() {
            @Override
            public int compare(SimpleImmutableObjectWithBuilder o1, SimpleImmutableObjectWithBuilder o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        
        assertThat(testObjects.get(0).getDescription()).isEqualTo("Ash Tree");
        assertThat(testObjects.get(1).getDescription()).isEqualTo("Elm Tree");
        assertThat(testObjects.get(2).getDescription()).isEqualTo("Oak Tree");
    }

    // java 8+ with a lambda - syntax 1
    @Test
    public void testConciseLambdaSyntax() {
        List<SimpleImmutableObjectWithBuilder> testObjects = getTestObjects();
        
        testObjects.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
        
        assertThat(testObjects.get(0).getDescription()).isEqualTo("Ash Tree");
        assertThat(testObjects.get(1).getDescription()).isEqualTo("Elm Tree");
        assertThat(testObjects.get(2).getDescription()).isEqualTo("Oak Tree");
    }

    // java 8+ with a lambda - syntax 2
    @Test
    public void testVerboseLambdaSyntax() {
        List<SimpleImmutableObjectWithBuilder> testObjects = getTestObjects();
        
        testObjects.sort((o1, o2) -> {
            return o1.getId().compareTo(o2.getId());
        });
        
        assertThat(testObjects.get(0).getDescription()).isEqualTo("Ash Tree");
        assertThat(testObjects.get(1).getDescription()).isEqualTo("Elm Tree");
        assertThat(testObjects.get(2).getDescription()).isEqualTo("Oak Tree");
    }

    // java 8+ with a lambda - syntax 3
    @Test
    public void testVeryVerboseLambdaSyntax() {
        List<SimpleImmutableObjectWithBuilder> testObjects = getTestObjects();
        
        testObjects.sort((SimpleImmutableObjectWithBuilder o1,
                SimpleImmutableObjectWithBuilder o2) -> {
            return o1.getId().compareTo(o2.getId());
        });
        
        assertThat(testObjects.get(0).getDescription()).isEqualTo("Ash Tree");
        assertThat(testObjects.get(1).getDescription()).isEqualTo("Elm Tree");
        assertThat(testObjects.get(2).getDescription()).isEqualTo("Oak Tree");
    }

    // java 8+ with method reference
    @Test
    public void testMethodReference() {
        List<SimpleImmutableObjectWithBuilder> testObjects = getTestObjects();
        
        testObjects.sort(this::compare);
        
        assertThat(testObjects.get(0).getDescription()).isEqualTo("Ash Tree");
        assertThat(testObjects.get(1).getDescription()).isEqualTo("Elm Tree");
        assertThat(testObjects.get(2).getDescription()).isEqualTo("Oak Tree");
    }
    
    private int compare(SimpleImmutableObjectWithBuilder o1, SimpleImmutableObjectWithBuilder o2) {
        return o1.getId().compareTo(o2.getId());
    }
    
    private List<SimpleImmutableObjectWithBuilder> getTestObjects() {
        List<SimpleImmutableObjectWithBuilder> answer = new ArrayList<>();
        
        answer.add(SimpleImmutableObjectWithBuilder.of(33, "Oak Tree"));
        answer.add(SimpleImmutableObjectWithBuilder.of(22, "Elm Tree"));
        answer.add(SimpleImmutableObjectWithBuilder.of(11, "Ash Tree"));
        
        return answer;
    }
}
