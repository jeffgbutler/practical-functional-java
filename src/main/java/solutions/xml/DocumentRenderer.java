package solutions.xml;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import xml.model.AbstractDocType;
import xml.model.Document;

public class DocumentRenderer {

    public String render(Document document) {
        return Stream.of(renderXmlHeader(),
                renderDocType(document),
                renderRootElement(document))
                .flatMap(Function.identity())
                .collect(Collectors.joining("\n"));
    }

    private Stream<String> renderXmlHeader() {
        return Stream.of("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    }
    
    private Stream<String> renderDocType(Document document) {
        return Stream.of("<!DOCTYPE "
                + document.rootElement().name()
                + document.docType().map(this::renderDocType).orElse("")
                + ">");
    }
    
    private String renderDocType(AbstractDocType docType) {
        return " " + docType.accept(new DocTypeRenderer());
    }
    
    private Stream<String> renderRootElement(Document document) {
        return document.rootElement().accept(new ElementRenderer());
    }
}
