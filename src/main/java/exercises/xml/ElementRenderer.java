package exercises.xml;

import java.util.stream.Stream;

import xml.model.ElementVisitor;
import xml.model.TextElement;
import xml.model.XmlElement;
import xml.model.XmlElementWithChildren;

public class ElementRenderer implements ElementVisitor<Stream<String>> {

    @Override
    public Stream<String> visit(TextElement element) {
        // TODO... return a Stream with just the content of the element
        return null;
    }

    @Override
    public Stream<String> visit(XmlElement element) {
        // TODO - return a stream with just the element and attributes: <foo name="fred"/>
        return null;
    }
    
    @Override
    public Stream<String> visit(XmlElementWithChildren element) {
        // TODO - return a stream with the open tag and attributes, rendered children (indented 2 spaces)
        // and the closing tag
        return null;
    }
}
