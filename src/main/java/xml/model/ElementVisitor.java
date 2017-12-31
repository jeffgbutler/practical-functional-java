package xml.model;

public interface ElementVisitor<R> {
    R visit(TextElement element);
    R visit(XmlElement element);
}
