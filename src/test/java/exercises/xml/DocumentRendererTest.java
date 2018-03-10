package exercises.xml;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import xml.model.Attributes;
import xml.model.Document;
import xml.model.PublicDocType;
import xml.model.SystemDocType;
import xml.model.TextElement;
import xml.model.XmlElement;
import xml.model.XmlElementWithChildren;

@Disabled
public class DocumentRendererTest {

    @Test
    public void testMinimalDocument() {
        XmlElement element = new XmlElement.Builder()
                .withName("testElement")
                .build();
        
        Document document = new Document.Builder()
                .withRootElement(element)
                .build();
        
        String answer = new DocumentRenderer().render(document);
        
        String expected =
                  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<!DOCTYPE testElement>\n"
                + "<testElement />";
        
        assertThat(answer).isEqualTo(expected);
    }
    
    @Test
    public void testMinimalDocumentWithSystemDocType() {
        XmlElement element = new XmlElement.Builder()
                .withName("testElement")
                .withAttributes(Attributes.of("foo", "bar"))
                .build();
        
        SystemDocType docType = SystemDocType.of("example.dtd");
        
        Document document = new Document.Builder()
                .withRootElement(element)
                .withDocType(docType)
                .build();
        
        String answer = new DocumentRenderer().render(document);
        
        String expected =
                  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<!DOCTYPE testElement SYSTEM \"example.dtd\">\n"
                + "<testElement foo=\"bar\" />";
        
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    public void testDocumentAttributeAndText() {
        XmlElementWithChildren element = new XmlElementWithChildren.Builder()
                .withName("testElement")
                .withAttributes(Attributes.of("foo", "bar"))
                .withChild(TextElement.of("some text"))
                .build();
        
        SystemDocType docType = SystemDocType.of("example.dtd");
        
        Document document = new Document.Builder()
                .withRootElement(element)
                .withDocType(docType)
                .build();
        
        String answer = new DocumentRenderer().render(document);
        
        String expected =
                  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<!DOCTYPE testElement SYSTEM \"example.dtd\">\n"
                + "<testElement foo=\"bar\" >\n"
                + "  some text\n"
                + "</testElement>";
        
        
        assertThat(answer).isEqualTo(expected);
    }
    
    @Test
    public void textComplexDocument() {
        XmlElementWithChildren element = new XmlElementWithChildren.Builder()
                .withName("testElement")
                .withAttributes(Attributes.of("foo", "bar"))
                .withChild(TextElement.of("some text"))
                .build();

        XmlElementWithChildren subElement = new XmlElementWithChildren.Builder()
                .withName("subElement1")
                .withAttributes(Attributes.of("name", "fred"))
                .withChild(TextElement.of("more text"))
                .build();
        
        element = element.withChild(subElement);
        
        XmlElement subElement2 = new XmlElement.Builder()
                .withName("subElement2")
                .build();
        
        element = element.withChild(subElement2);
        
        PublicDocType docType = new PublicDocType.Builder()
                .withDtdLocation("example.dtd")
                .withDtdName("-//Example//EN")
                .build();
        
        Document document = new Document.Builder()
                .withRootElement(element)
                .withDocType(docType)
                .build();
        
        String answer = new DocumentRenderer().render(document);

        String expected =
                  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<!DOCTYPE testElement PUBLIC \"-//Example//EN\" \"example.dtd\">\n"
                + "<testElement foo=\"bar\" >\n"
                + "  some text\n"
                + "  <subElement1 name=\"fred\" >\n"
                + "    more text\n"
                + "  </subElement1>\n"
                + "  <subElement2 />\n"
                + "</testElement>";
        
        assertThat(answer).isEqualTo(expected);
    }
}
