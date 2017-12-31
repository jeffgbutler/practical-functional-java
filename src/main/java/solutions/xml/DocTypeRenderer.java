package solutions.xml;

import xml.model.DocTypeVisitor;
import xml.model.PublicDocType;
import xml.model.SystemDocType;

public class DocTypeRenderer implements DocTypeVisitor<String> {

    @Override
    public String visit(PublicDocType doctype) {
        return "PUBLIC \""
                + doctype.dtdName()
                + "\" \""
                + doctype.dtdLocation()
                + "\"";
    }

    @Override
    public String visit(SystemDocType doctype) {
        return "SYSTEM \""
                + doctype.dtdLocation()
                + "\"";
    }
}
