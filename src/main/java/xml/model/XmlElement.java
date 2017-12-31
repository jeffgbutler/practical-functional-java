package xml.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class XmlElement implements VisitableElement {
    
    private String name;
    private Optional<Attributes> attributes;
    private List<VisitableElement> children;

    private XmlElement(Builder builder) {
        name = Objects.requireNonNull(builder.name);
        attributes = builder.attributes;
        children = builder.children;
    }
    
    private XmlElement(XmlElement other) {
        name = other.name;
        attributes = other.attributes;
        children = new ArrayList<>(other.children);
    }
    
    public String name() {
        return name;
    }
    
    public Optional<Attributes> attributes() {
        return attributes;
    }

    public Stream<VisitableElement> children() {
        return children.stream();
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public XmlElement withChild(VisitableElement child) {
        XmlElement copy = new XmlElement(this);
        copy.children.add(child);
        return copy;
    }
    
    @Override
    public <R> R accept(ElementVisitor<R> visitor) {
        return visitor.visit(this);
    }
    
    public static class Builder {
        private String name;
        private Optional<Attributes> attributes = Optional.empty();
        private List<VisitableElement> children = new ArrayList<>();
        
        public Builder withName(String name) {
            this.name = name;
            return this;
        }
        
        public Builder withAttributes(Attributes attributes) {
            this.attributes = Optional.of(attributes);
            return this;
        }
        
        public Builder withChildren(List<VisitableElement> children) {
            this.children.addAll(children);
            return this;
        }

        public Builder withChild(VisitableElement child) {
            this.children.add(child);
            return this;
        }
        
        public XmlElement build() {
            return new XmlElement(this);
        }
    }
}
