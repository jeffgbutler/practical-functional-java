package xml.model;

import java.util.Objects;

public class TextElement implements VisitableElement {
    
    private String content;

    private TextElement(String content) {
        this.content = Objects.requireNonNull(content);
    }

    public String content() {
        return content;
    }

    @Override
    public <R> R accept(ElementVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public static TextElement of(String content) {
        return new TextElement(content);
    }
}
