package exercises.xml;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

import xml.model.Attribute;
import xml.model.Attributes;

@Ignore
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
