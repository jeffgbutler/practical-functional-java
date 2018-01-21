package xml.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class XmlElementWithChildren extends XmlElement {
    
    private List<VisitableElement> children;

    private XmlElementWithChildren(Builder builder) {
        super(builder);
        children = builder.children;
    }
    
    private XmlElementWithChildren(XmlElementWithChildren other) {
        super(other);
        children = new ArrayList<>(other.children);
    }
    
    public Stream<VisitableElement> children() {
        return children.stream();
    }

    @Override
    public XmlElementWithChildren withChild(VisitableElement child) {
        XmlElementWithChildren copy = new XmlElementWithChildren(this);
        copy.children.add(child);
        return copy;
    }
    
    @Override
    public <R> R accept(ElementVisitor<R> visitor) {
        return visitor.visit(this);
    }
    
    public static class Builder extends XmlElement.AbstractBuilder<Builder> {
        private List<VisitableElement> children = new ArrayList<>();
        
        public Builder withChildren(List<VisitableElement> children) {
            this.children.addAll(children);
            return this;
        }

        public Builder withChild(VisitableElement child) {
            this.children.add(child);
            return this;
        }
        
        public XmlElementWithChildren build() {
            return new XmlElementWithChildren(this);
        }
        
        protected Builder getThis() {
            return this;
        }
    }
}
