package examples.immutable;

import java.util.Objects;

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
