package xml.model;

import java.util.Objects;
import java.util.Optional;

public class XmlElement implements VisitableElement {
    
    private String name;
    private Attributes attributes;

    protected XmlElement(AbstractBuilder<?> builder) {
        name = Objects.requireNonNull(builder.name);
        attributes = builder.attributes;
    }
    
    protected XmlElement(XmlElement other) {
        name = other.name;
        attributes = other.attributes;
    }
    
    public String name() {
        return name;
    }
    
    public Optional<Attributes> attributes() {
        return Optional.ofNullable(attributes);
    }

    public XmlElementWithChildren withChild(VisitableElement child) {
        return new XmlElementWithChildren.Builder()
                .withName(name)
                .withAttributes(attributes)
                .withChild(child)
                .build();
    }

    @Override
    public <R> R accept(ElementVisitor<R> visitor) {
        return visitor.visit(this);
    }
    
    protected static abstract class AbstractBuilder<T extends AbstractBuilder<T>> {
        private String name;
        private Attributes attributes;
        
        public T withName(String name) {
            this.name = name;
            return getThis();
        }
        
        public T withAttributes(Attributes attributes) {
            this.attributes = attributes;
            return getThis();
        }
        
        protected abstract T getThis();
    }
    
    public static class Builder extends AbstractBuilder<Builder> {
        public XmlElement build() {
            return new XmlElement(this);
        }
        
        protected Builder getThis() {
            return this;
        }
    }
}
