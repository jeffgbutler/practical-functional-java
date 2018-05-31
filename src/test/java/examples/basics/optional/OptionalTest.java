package examples.basics.optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;

public class OptionalTest {

    @Test
    public void testCreatingOptionals() {
        Optional<String> name = Optional.of("Fred"); // value must be non-null
        assertThat(name.isPresent()).isTrue();

        name = Optional.ofNullable("Fred");  // value may be null
        assertThat(name.isPresent()).isTrue();

        name = Optional.ofNullable(null);
        assertThat(name.isPresent()).isFalse();

        name = Optional.empty();  // always empty
        assertThat(name.isPresent()).isFalse();
    }
    
    // the map method is used to transform an optional if it exists
    @Test
    public void testOptionalMap() {
        Optional<String> name = Optional.of("Fred");
        
        Optional<String> upperName = name.map(String::toUpperCase);
        
        assertThat(upperName.isPresent()).isTrue();
        assertThat(upperName.get()).isEqualTo("FRED");
    }

    // the map method works on an empty Optional - just returns an empty Optional
    @Test
    public void testOptionalMapOnEmpty() {
        Optional<String> emptyName = Optional.empty();  // or Optional.ofNullable(null);
        
        Optional<String> emptyUpperName = emptyName.map(String::toUpperCase);
        
        assertThat(emptyUpperName.isPresent()).isFalse();
        
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> {
            assertThat(emptyUpperName.get()).isEqualTo("FRED");
        });
    }
    
    // the filter method is used to test the value of an optional if present
    @Test
    public void testOptionalFilter() {
        Optional<String> name = Optional.of("Fred");
        
        Optional<String> fred = name.filter(s -> s.equals("Fred"));
        Optional<String> notFred = name.filter(s -> !s.equals("Fred"));
        
        assertThat(fred.isPresent()).isTrue();
        assertThat(notFred.isPresent()).isFalse();
    }

    // just like streams, optional methods can be chained
    @Test
    public void testOptionalMethodChaining() {
        Optional<String> name = Optional.of("Fred");
        
        Optional<String> upperFred = name.filter(s -> s.equals("Fred"))
                .map(String::toUpperCase);
                
        assertThat(upperFred.isPresent()).isTrue();
        assertThat(upperFred.get()).isEqualTo("FRED");
    }

    // orElse is used to supply a default value if the optional is empty
    @Test
    public void testOptionalOrElse() {
        Optional<String> fred = Optional.of("Fred");
        
        String upperFred = fred.filter(s -> s.equals("Fred"))
                .map(String::toUpperCase)
                .orElse("Unknown");
                
        assertThat(upperFred).isEqualTo("FRED");

        Optional<String> barney = Optional.of("Barney");
        
        upperFred = barney.filter(s -> s.equals("Fred"))
                .map(String::toUpperCase)
                .orElse("Unknown");
                
        assertThat(upperFred).isEqualTo("Unknown");
    }
    
    // the Optional.ifPresent method is for side effects.
    // We don't want side effects, so don't do this
    @Test
    public void testOptionalIfPresent() {
        Optional<String> name = Optional.of("Fred");

        StringBuilder sb = new StringBuilder();
        name.ifPresent(s -> {
            sb.append(s.toUpperCase());
        });

        assertThat(sb.toString()).isEqualTo("FRED");
    }

// Java 9 adds a few methods to Optional.
    
//    Optional.stream returns a stream of one thing, or empty stream
//    @Test
//    public void testOptionalStream() {
//        Optional<String> name = Optional.of("Fred");
//        
//        String names = Stream.of(Stream.of("Barney"),
//                name.stream())
//                .flatMap(Function.identity())
//                .collect(Collectors.joining(" "));
//        
//        assertThat(names).isEqualTo("Barney Fred");
//
//        names = Stream.of(Stream.of("Barney"),
//                name.filter(s -> s.equals("Wilma")).stream())
//                .flatMap(Function.identity())
//                .collect(Collectors.joining(" "));
//        
//        assertThat(names).isEqualTo("Barney");
//    }

//    Optional.or allows you to specify a default optional supplier
//    @Test
//    public void testOptionalOr() {
//        Optional<String> name = Optional.of("Fred");
//        
//        Optional<String> fred = name.filter(s -> s.equals("Fred"))
//                .or(() -> Optional.of("Barney"));
//        
//        assertThat(fred.isPresent()).isTrue();
//        assertThat(fred.get()).isEqualTo("Fred");
//        
//        
//        Optional<String> notFred = name.filter(s -> !s.equals("Fred"))
//                .or(() -> Optional.of("Barney"));
//        
//        assertThat(notFred.isPresent()).isTrue();
//        assertThat(notFred.get()).isEqualTo("Barney");
//    }
}
