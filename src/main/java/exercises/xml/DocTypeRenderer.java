package exercises.xml;

import xml.model.DocTypeVisitor;
import xml.model.PublicDocType;
import xml.model.SystemDocType;

public class DocTypeRenderer implements DocTypeVisitor<String> {

    @Override
    public String visit(PublicDocType doctype) {
        // TODO - render doc type: PUBLIC "dtdName" "dtdLocation"
        return null;
    }

    @Override
    public String visit(SystemDocType doctype) {
        // TODO - render doc type: SYSTEM "dtdLocation"
        return null;
    }
}
