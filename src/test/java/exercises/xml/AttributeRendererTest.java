package exercises.xml;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import xml.model.Attribute;
import xml.model.Attributes;

@Disabled
public class AttributeRendererTest {

    @Test
    public void testSingleAttribute() {
        Attribute attribute = Attribute.of("foo", "bar");
        
        assertThat(new AttributeRenderer().renderAttribute(attribute)).isEqualTo("foo=\"bar\"");
    }

    @Test
    public void testMultipleAttributes() {
        Attributes attributes = Attributes.of(
                Attribute.of("name", "fred"),
                Attribute.of("foo", "bar"));
        
        assertThat(new AttributeRenderer().renderAttributes(attributes)).isEqualTo("foo=\"bar\" name=\"fred\"");
    }
}
