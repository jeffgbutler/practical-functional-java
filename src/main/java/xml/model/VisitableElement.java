package xml.model;

@FunctionalInterface
public interface VisitableElement {
    <R> R accept(ElementVisitor<R> visitor);
}
