package xml.model;

public interface DocTypeVisitor<R> {
    R visit(PublicDocType doctype);
    R visit(SystemDocType doctype);
}
