package solutions.xml;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Collectors;

import org.junit.Test;

import xml.model.Attributes;
import xml.model.TextElement;
import xml.model.XmlElement;

public class ElementRendererTest {

    @Test
    public void testTextElement() {
        TextElement element = TextElement.of("some text");
        
        String answer = element.accept(new ElementRenderer())
                .collect(Collectors.joining("\n"));
        
        assertThat(answer).isEqualTo("some text");
    }
    
    @Test
    public void testEmptyElementNoAttributes() {
        XmlElement element = new XmlElement.Builder()
                .withName("testElement")
                .build();
        
        String answer = element.accept(new ElementRenderer())
                .collect(Collectors.joining("\n"));
        
        assertThat(answer).isEqualTo("<testElement />");
    }
    
    @Test
    public void testEmptyElementWithAttribute() {
        XmlElement element = new XmlElement.Builder()
                .withName("testElement")
                .withAttributes(Attributes.of("foo", "bar"))
                .build();
        
        String answer = element.accept(new ElementRenderer())
                .collect(Collectors.joining("\n"));
        
        assertThat(answer).isEqualTo("<testElement foo=\"bar\" />");
    }

    @Test
    public void testElementWithAttributeAndText() {
        XmlElement element = new XmlElement.Builder()
                .withName("testElement")
                .withAttributes(Attributes.of("foo", "bar"))
                .withChild(TextElement.of("some text"))
                .build();
        
        String answer = element.accept(new ElementRenderer())
                .collect(Collectors.joining("\n"));

        String expected =
                  "<testElement foo=\"bar\" >\n"
                + "  some text\n"
                + "</testElement>";
        
        assertThat(answer).isEqualTo(expected);
    }
    
    @Test
    public void textComplexElement() {
        XmlElement element = new XmlElement.Builder()
                .withName("testElement")
                .withAttributes(Attributes.of("foo", "bar"))
                .withChild(TextElement.of("some text"))
                .build();

        XmlElement subElement = new XmlElement.Builder()
                .withName("subElement1")
                .withAttributes(Attributes.of("name", "fred"))
                .withChild(TextElement.of("more text"))
                .build();
        
        element = element.withChild(subElement);
        
        subElement = new XmlElement.Builder()
                .withName("subElement2")
                .build();
        
        element = element.withChild(subElement);
        
        String answer = element.accept(new ElementRenderer())
                .collect(Collectors.joining("\n"));

        String expected =
                  "<testElement foo=\"bar\" >\n"
                + "  some text\n"
                + "  <subElement1 name=\"fred\" >\n"
                + "    more text\n"
                + "  </subElement1>\n"
                + "  <subElement2 />\n"
                + "</testElement>";
        
        assertThat(answer).isEqualTo(expected);
    }
}
