package examples.basics.immutable;

import java.util.Objects;

// This is a more extensible way to build an immutable object - with a fluent builder.
public final class SimpleImmutableObjectWithBuilder {
    private final Integer id;
    private final String description;
    
    private SimpleImmutableObjectWithBuilder(Builder builder) {
        this.id = Objects.requireNonNull(builder.id);
        this.description = Objects.requireNonNull(builder.description);
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    // you can add one or more convenience "of" methods if they make sense.  But beware too many
    // parameters to a method.  I put the limit at three parameters.  Less if there are
    // parameters with the same datatype (e.g. 3 String parameters is a bad idea)
    public static SimpleImmutableObjectWithBuilder of(Integer id, String description) {
        return new Builder()
                .withId(id)
                .withDescription(description)
                .build();
    }
    
    public static class Builder {
        private Integer id;
        private String description;
        
        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }
        
        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }
        
        public SimpleImmutableObjectWithBuilder build() {
            return new SimpleImmutableObjectWithBuilder(this);
        }
    }
}
