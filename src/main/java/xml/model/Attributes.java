package xml.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Attributes {

    private List<Attribute> attributes;
    
    private Attributes(Builder builder) {
        attributes = Objects.requireNonNull(builder.attributes);
    }
    
    public Stream<Attribute> attributes() {
        return attributes.stream();
    }
    
    public static Attributes of(String name, String value) {
        return new Builder()
                .withAttributes(Attribute.of(name, value))
                .build();
    }
    public static Attributes of(Attribute...attributes) {
        return new Builder()
                .withAttributes(attributes)
                .build();
    }
    
    public static class Builder {
        private List<Attribute> attributes = new ArrayList<>();
        
        public Builder withAttribute(Attribute attribute) {
            attributes.add(attribute);
            return this;
        }

        public Builder withAttributes(Attribute...attributes) {
            this.attributes.addAll(Arrays.asList(attributes));
            return this;
        }

        public Attributes build() {
            return new Attributes(this);
        }
    }
}
