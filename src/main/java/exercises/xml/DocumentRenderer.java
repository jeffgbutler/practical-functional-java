package exercises.xml;

import java.util.stream.Stream;

import xml.model.Document;

public class DocumentRenderer {

    public String render(Document document) {
        // TODO - return the full document with a proper XML header, doctype, and rendered root element
        return null;
    }

    private Stream<String> renderXmlHeader() {
        return Stream.of("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    }
}
