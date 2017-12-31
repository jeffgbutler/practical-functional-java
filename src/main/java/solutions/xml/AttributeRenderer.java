package solutions.xml;

import java.util.stream.Collectors;

import xml.model.Attribute;
import xml.model.Attributes;

public class AttributeRenderer {
    public String renderAttribute(Attribute attribute) {
        return attribute.name()
                + "=\""
                + attribute.value()
                + "\"";
    }

    public String renderAttributes(Attributes attributes) {
        return attributes.attributes()
                .sorted()
                .map(this::renderAttribute)
                .collect(Collectors.joining(" "));
    }
}
