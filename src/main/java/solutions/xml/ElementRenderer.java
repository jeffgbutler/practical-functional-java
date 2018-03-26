package solutions.xml;

import java.util.stream.Stream;

import xml.model.Attributes;
import xml.model.ElementVisitor;
import xml.model.TextElement;
import xml.model.VisitableElement;
import xml.model.XmlElement;
import xml.model.XmlElementWithChildren;

public class ElementRenderer implements ElementVisitor<Stream<String>> {

    @Override
    public Stream<String> visit(TextElement element) {
        return Stream.of(element.content());
    }

    @Override
    public Stream<String> visit(XmlElement element) {
        return Stream.of("<"
                + element.name()
                + renderAttributes(element)
                + "/>");
    }

    @Override
    public Stream<String> visit(XmlElementWithChildren element) {
        // can also do this with Stream concatenation and make a deeply nested
        // lazy stream.  But there is a caution against doing that in the
        // JavaDocs for Stream.concat
        return Stream.of(renderOpen(element),
                renderChildren(element),
                renderClose(element))
                .flatMap(s -> s);  // Function.identity() works here too
    }
    
    
    private String renderAttributes(XmlElement element) {
        return element.attributes().map(this::renderAttributes)
                .orElse("");
    }
    
    private String renderAttributes(Attributes attributes) {
        return " " + new AttributeRenderer().renderAttributes(attributes);
    }

    private Stream<String> renderOpen(XmlElement element) {
        return Stream.of("<"
                + element.name()
                + renderAttributes(element)
                + ">");
    }
    
    private Stream<String> renderChildren(XmlElementWithChildren element) {
        return element.children()
                .flatMap(this::renderChild)
                .map(this::indent);
    }
    
    private Stream<String> renderChild(VisitableElement child) {
        return child.accept(this);
    }
    
    private String indent(String s) {
        return "  " + s;
    }
    
    private Stream<String> renderClose(XmlElement element) {
        return Stream.of("</"
                + element.name()
                + ">");
    }
}
