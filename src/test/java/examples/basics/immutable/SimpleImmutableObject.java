package examples.basics.immutable;

import java.util.Objects;

// This is the simplest way to build an immutable object.  But it will quickly get out of
// hand if there are more than one or two attributes
public final class SimpleImmutableObject {
    private final Integer id;
    private final String description;
    
    public SimpleImmutableObject(Integer id, String description) {
        this.id = Objects.requireNonNull(id);
        this.description = Objects.requireNonNull(description);
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
