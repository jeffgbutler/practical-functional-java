package xml.model;

import java.util.Objects;
import java.util.Optional;

public class Document {
    
    private Optional<AbstractDocType> docType;
    private XmlElement rootElement;

    private Document(Builder builder) {
        rootElement = Objects.requireNonNull(builder.rootElement);
        docType = Optional.ofNullable(builder.docType);
    }

    public XmlElement rootElement() {
        return rootElement;
    }

    public Optional<AbstractDocType> docType() {
        return docType;
    }

    public static class Builder {
        private AbstractDocType docType;
        private XmlElement rootElement;
        
        public Builder withRootElement(XmlElement rootElement) {
            this.rootElement = rootElement;
            return this;
        }
        
        public Builder withDocType(AbstractDocType docType) {
            this.docType = docType;
            return this;
        }
        
        public Document build() {
            return new Document(this);
        }
    }
}
